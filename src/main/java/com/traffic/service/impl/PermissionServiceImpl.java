package com.traffic.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.traffic.entity.Role;
import com.traffic.entity.RolePermission;
import com.traffic.mapper.*;
import com.traffic.entity.Permission;
import com.traffic.service.PermissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Permission)表服务实现类
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:40
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RolePermissionDao rolePermissionDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserRoleDao userRoleDao;


    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<Permission> getPermissionList(Object userId) {
        //获取角色集合的roleId
        List<Role> roleList = getRoleList(userId);
        List<String> roles = roleList.stream().map(Role::getRoleId).collect(Collectors.toList());

        //根据角色Id获取角色权限
        LambdaQueryWrapper<RolePermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(RolePermission::getRoleId,roles);
        List<RolePermission> rolePermissions = rolePermissionDao.selectList(wrapper);
        List<String> permissions = rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        LambdaQueryWrapper<Permission> perWrapper = new LambdaQueryWrapper<>();
        perWrapper.in(Permission::getPermissionId,permissions);
        return permissionDao.selectList(perWrapper);
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<Role> getRoleList(Object userId) {
        return roleDao.getRoleList(userId);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(Integer id) {
        return this.permissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param permission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Permission> queryByPage(Permission permission, PageRequest pageRequest) {
        long total = this.permissionDao.count(permission);
        return new PageImpl<>(this.permissionDao.queryAllByLimit(permission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        this.permissionDao.update(permission);
        return this.queryById(permission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.permissionDao.deleteById(id) > 0;
    }
}
