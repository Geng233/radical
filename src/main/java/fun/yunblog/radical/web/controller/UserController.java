package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.UserService;
import fun.yunblog.radical.model.token.JwtToken;
import fun.yunblog.radical.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 耿子云
 * @date 2021/9/26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("账号密码不能为空"));
        }
        Subject subject = SecurityUtils.getSubject();
        String jwt = JwtUtil.createJWT(user.getUserName(), "back", "user", 1000 * 60 * 30);
        JwtToken jwtToken = new JwtToken(jwt, user.getPassword());
        try {
            subject.login(jwtToken);
        } catch (UnknownAccountException e) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("账号不存在"));
        } catch (IncorrectCredentialsException e) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("密码不存在"));
        } catch (Exception e) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("未知错误"));
        }
        User backUser = userService.queryUserByUserName(user.getUserName());
        backUser.setPassword("");
        backUser.setSalt("");
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", backUser);
        map.put("token", jwtToken.getToken());
        return JSON.toJSONString(new Result().setCode(200).setMessage("登陆成功").setData(map));
    }

    @ApiOperation("获取用户菜单")
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("未登陆"));
        }
        List<Map<String, Object>> maps = userService.queryMenu(userName);
        return JSON.toJSONString(new Result().setCode(200).setMessage("获取用户菜单成功").setData(maps));
    }

    @ApiOperation("根据名字获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String userInfo(String userName) {
        System.out.println(userName);
        User user = userService.queryUserByUserName(userName);
        if (user == null) {
            return JSON.toJSONStringWithDateFormat(new Result().setCode(400).setMessage("没有该用户"), "yyyy-MM-dd  HH:mm:ss");

        }
        user.setPassword("");
        return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("请求成功").setData(user), "yyyy-MM-dd  HH:mm:ss");
    }

    @ApiOperation("修改用户的密码")
    @RequestMapping(value = "/alterPassword", method = RequestMethod.PUT)
    public String alterArticle(@RequestBody Map<String, String> map) {
        boolean res = userService.alterPassWordByUserName(map.get("oldPassword"), map.get("password"), map.get("userName"));
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("修改用户密码成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("修改用户密码失败"));
        }
    }

    @ApiOperation("修改用户信息(只需提供不敏感的信息即可)")
    @RequestMapping(value = "/alter", method = RequestMethod.PUT)
    public String alter(@RequestBody User user) {
        System.out.println(user);
        boolean res = userService.alterUserInfo(user);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("修改用户成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("修改用户失败"));
        }
    }
}
