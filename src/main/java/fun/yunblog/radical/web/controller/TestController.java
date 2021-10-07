package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequiresPermissions("permissionCode1")
    @ApiOperation("测试接口1")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return JSON.toJSONString(new Result().setCode(200).setMessage("message is test1").setData("data is test1"));
    }


    @ApiOperation("测试接口2")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        return JSON.toJSONString(new Result().setCode(200).setMessage("message is test1").setData("data is test1"));
    }
}
