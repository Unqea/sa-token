package com.traffic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traffic.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (RolePermission)表数据库访问层
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:42
 */
@Repository
public interface RolePermissionDao extends BaseMapper<RolePermission> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolePermission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param rolePermission 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RolePermission> queryAllByLimit(RolePermission rolePermission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rolePermission 查询条件
     * @return 总行数
     */
    long count(RolePermission rolePermission);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int insert(RolePermission rolePermission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RolePermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RolePermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RolePermission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RolePermission> entities);

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int update(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

