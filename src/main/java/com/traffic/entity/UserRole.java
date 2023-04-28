package com.traffic.entity;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author Yinhenan
 * @since 2023-01-10 10:28:42
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = -67436852230076386L;
    
    private Integer id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}

