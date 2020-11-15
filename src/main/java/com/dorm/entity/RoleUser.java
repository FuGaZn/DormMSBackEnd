package com.dorm.entity;

import javax.persistence.*;
import java.util.Objects;

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

    @Column
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser roleUser = (RoleUser) o;
        return userId == roleUser.userId &&
                roleId == roleUser.roleId &&
                status == roleUser.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId, status);
    }
}
