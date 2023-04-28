package com.traffic.service.impl;

import com.traffic.mapper.RolePermissionDao;
import com.traffic.entity.RolePermission;
import com.traffic.service.RolePermissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RolePermission)表服务实现类
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:42
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionDao rolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RolePermission queryById(Integer id) {
        return this.rolePermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param rolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RolePermission> queryByPage(RolePermission rolePermission, PageRequest pageRequest) {
        long total = this.rolePermissionDao.count(rolePermission);
        return new PageImpl<>(this.rolePermissionDao.queryAllByLimit(rolePermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermission insert(RolePermission rolePermission) {
        this.rolePermissionDao.insert(rolePermission);
        return rolePermission;
    }

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermission update(RolePermission rolePermission) {
        this.rolePermissionDao.update(rolePermission);
        return this.queryById(rolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rolePermissionDao.deleteById(id) > 0;
    }
}
