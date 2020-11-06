package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_access")
public class RoleAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int raid;
    @Column
    int role_id;
    @Column
    int access_id;

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getAccess_id() {
        return access_id;
    }

    public void setAccess_id(int access_id) {
        this.access_id = access_id;
    }
}
