package com.traffic.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.traffic.common.ApiResult;
import com.traffic.entity.User;
import com.traffic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户登录 API")
@RestController
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "登录", response = ApiResult.class)
    @GetMapping("doLogin")
    public ApiResult<SaTokenInfo> doLogin(String username, String password) {
        User user = userService.doLogin(username, password);
        if (user != null){
            return ApiResult.ok(StpUtil.getTokenInfo());
        }
        return ApiResult.fail();
    }

    @ApiOperation(value = "判断登录状态", notes = "判断登录状态", response = ApiResult.class)
    @GetMapping("isLogin")
    public ApiResult<Boolean> isLogin() {
        return ApiResult.result(StpUtil.isLogin());
    }

    @ApiOperation(value = "退出登录", notes = "退出登录", response = ApiResult.class)
    @GetMapping("exitLogin")
    public ApiResult<String> exitLogin() {
        StpUtil.logout();
        return ApiResult.ok("退出登录");
    }

    @ApiOperation(value = "获取当前会话的token值", notes = "获取当前会话的token值", response = ApiResult.class)
    @GetMapping("getToken")
    public ApiResult<String> getToken() {
        String tokenValue = StpUtil.getTokenValue();
        return ApiResult.ok(tokenValue);
    }

    @ApiOperation(value = "获取当前的token名称", notes = "获取当前的token名称", response = ApiResult.class)
    @GetMapping("getTokenName")
    public ApiResult<String> getTokenName() {
        return ApiResult.ok(StpUtil.getTokenName());
    }

    @ApiOperation(value = "获取当前会话剩余有效期", notes = "获取当前会话剩余有效期", response = ApiResult.class)
    @GetMapping("getTokenTime")
    public ApiResult<Long> getTokenTime() {
        return ApiResult.ok(StpUtil.getTokenTimeout());
    }

    @ApiOperation(value = "获取当前会话的token信息参数", notes = "获取当前会话的token信息参数", response = ApiResult.class)
    @GetMapping("getTokenParam")
    public ApiResult<SaTokenInfo> getTokenParam() {
        return ApiResult.ok(StpUtil.getTokenInfo());
    }

    @SaCheckPermission(value = "user:logout", orRole = "admin")
    @ApiOperation(value = "强制指定账号注销下线 ", notes = "强制指定账号注销下线 ", response = ApiResult.class)
    @GetMapping("logoutById")
    public ApiResult<String> logoutById(Object userId) {
        StpUtil.logout(userId);
        return ApiResult.ok("注销下线");
    }

    @SaCheckPermission(value = "user:kickOut", orRole = "admin")
    @ApiOperation(value = "将指定账号踢下线  ", notes = "将指定账号踢下线  ", response = ApiResult.class)
    @GetMapping("kickOutById")
    public ApiResult<String> kickOutById(Object userId) {
        StpUtil.kickout(userId);
        return ApiResult.ok("踢下线");
    }


}
