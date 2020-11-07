package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_access")
public class RoleAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int raid;
    @Column(name = "role_id")
    int roleId;
    @Column(name = "access_id")
    int accessId;

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }
}
