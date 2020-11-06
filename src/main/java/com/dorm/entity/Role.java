package com.dorm.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rid;

    @Column
    String name;
    @Column
    int status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Set<RoleUser> roleUsers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Set<RoleAccess> roleAccesses;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<RoleUser> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }
}
