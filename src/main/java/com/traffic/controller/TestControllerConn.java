package com.traffic.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.traffic.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试注解拦截权限 API")
@RestController
@RequestMapping("/anno/")
//@SaCheckLogin
public class TestControllerConn {

    // 登录校验：只有登录之后才能进入该方法
    @SaCheckLogin
    @GetMapping("info")
    @ApiOperation(value = "是否登录", notes = "是否登录", response = ApiResult.class)
    public String info() {
        return "查询用户信息";
    }

    // 角色校验：必须具有指定角色才能进入该方法
    @SaCheckRole("admin")
    @GetMapping("addRoleAdmin")
    @ApiOperation(value = "是否有超级管理员权限", notes = "是否有超级管理员权限", response = ApiResult.class)
    public String addRoleAdmin() {
        return "用户增加";
    }

    // 权限校验：必须具有指定权限才能进入该方法
    @SaCheckPermission("user:add")
    @GetMapping("addPermission")
    @ApiOperation(value = "是否有添加权限", notes = "是否有添加权限", response = ApiResult.class)
    public String addPermission() {
        return "用户增加";
    }

    // 角色权限双重 “or校验”：具备指定权限或者指定角色即可通过校验
    @GetMapping("userAdd")
    @SaCheckPermission(value = "user:add", orRole = "admin")
    @ApiOperation(value = "是否是管理员或者是否有添加权限", notes = "是否是管理员或者是否有添加权限", response = ApiResult.class)
    public SaResult userAdd() {
        return SaResult.data("用户信息");
    }


    // 校验当前账号是否被封禁 comment 服务，如果已被封禁会抛出异常，无法进入方法
    @SaCheckDisable("comment")
    @GetMapping("send")
    @ApiOperation(value = "是否封禁", notes = "是否封禁", response = ApiResult.class)
    public String send() {
        return "查询用户信息";
    }


}
