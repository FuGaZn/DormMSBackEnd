package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_user")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ruid;

    @Column
    int user_id;

    @Column
    int role_id;

    public int getRuid() {
        return ruid;
    }

    public void setRuid(int ruid) {
        this.ruid = ruid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
                "ruid=" + ruid +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}
