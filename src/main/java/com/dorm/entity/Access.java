package com.dorm.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int aid;
    @Column
    String name;
    @Column
    int status;
    @Column
    int level;
    @Column
    String module;
    @Column
    String identifier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "access_id")
    Set<RoleAccess> roleAccesses;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Set<RoleAccess> getRoleAccesses() {
        return roleAccesses;
    }

    public void setRoleAccesses(Set<RoleAccess> roleAccesses) {
        this.roleAccesses = roleAccesses;
    }
}
