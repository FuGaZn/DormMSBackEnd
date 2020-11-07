package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_user")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ruid;

    @Column(name = "user_id")
    int userId;

    @Column(name = "role_id")
    int roleId;

    public int getRuid() {
        return ruid;
    }

    public void setRuid(int ruid) {
        this.ruid = ruid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
                "ruid=" + ruid +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
