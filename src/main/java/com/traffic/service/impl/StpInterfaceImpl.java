package com.traffic.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.traffic.entity.Permission;
import com.traffic.entity.Role;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private PermissionServiceImpl permissionService;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<Permission> permissionList = permissionService.getPermissionList(loginId);
        return permissionList.stream().map(Permission::getPerms).collect(Collectors.toList());
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Role> roleList = permissionService.getRoleList(loginId);
        return roleList.stream().map(Role::getName).collect(Collectors.toList());
    }

}
