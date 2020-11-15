package com.dorm.utils.vo;

import java.util.List;
import java.util.Set;

public class UserVO {
    int uid;
    String workerID;
    String name;
    List<String> roles;
    String lastLoginTime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uid=" + uid +
                ", workerID='" + workerID + '\'' +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }
}
