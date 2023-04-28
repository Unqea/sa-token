package com.traffic.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.traffic.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户权限 API")
@RestController
@RequestMapping("/permission/")
@SaCheckRole("admin")
public class PermissionController {

    @ApiOperation(value = "当前账号所拥有的权限集合", notes = "当前账号所拥有的权限集合", response = ApiResult.class)
    @GetMapping("getPermissionList")
    public ApiResult<List<String>> getPermissionList() {
        return ApiResult.ok(StpUtil.getPermissionList());
    }

    @ApiOperation(value = "当前账号所拥有的角色集合", notes = "当前账号所拥有的角色集合", response = ApiResult.class)
    @GetMapping("getRoleList")
    public ApiResult<List<String>> getRoleList() {
        return ApiResult.ok(StpUtil.getRoleList());
    }



}
