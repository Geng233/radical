package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.mapper.PermissionMapper;
import fun.yunblog.radical.model.domain.Permission;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @ApiOperation("获取用户权限")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public String permissions(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("未登陆"));
        }
        Set<Permission> permissions = permissionService.queryPermissionByUserName(userName);
        if (permissions.size() == 0) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("获取用户权限失败"));
        } else {
            return JSON.toJSONString(new Result().setCode(200).setMessage("获取用户权限成功").setData(permissions));
        }

    }

}
