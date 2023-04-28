package com.traffic.service;

import com.traffic.entity.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (RolePermission)表服务接口
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:42
 */
public interface RolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolePermission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param rolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RolePermission> queryByPage(RolePermission rolePermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    RolePermission insert(RolePermission rolePermission);

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    RolePermission update(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
