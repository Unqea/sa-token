package com.traffic.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.traffic.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("测试 API")
@RestController
@RequestMapping("/test/")
public class TestController {

    @ApiOperation(value = "测试添加", notes = "测试添加", response = ApiResult.class)
    @GetMapping("testAdd")
    public String testAdd() {
        boolean b = StpUtil.hasPermission("user:add");
        if (b){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @ApiOperation(value = "测试删除", notes = "测试删除", response = ApiResult.class)
    @GetMapping("testDel")
    public String testDel() {
        boolean b = StpUtil.hasPermission("user:delete");
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @ApiOperation(value = "新测试删除", notes = "新测试删除", response = ApiResult.class)
    @GetMapping("testDelNew")
    public String testDelNew() {
        boolean b = StpUtil.hasPermission("user:del");
        if (b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

}
