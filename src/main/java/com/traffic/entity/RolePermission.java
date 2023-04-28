package com.traffic.entity;

import java.io.Serializable;

/**
 * (RolePermission)实体类
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:42
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 756185064893231760L;
    
    private Integer id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 权限id
     */
    private String permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

}

