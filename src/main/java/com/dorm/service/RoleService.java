package com.dorm.service;

import com.dorm.entity.Access;
import com.dorm.entity.Role;
import com.dorm.entity.RoleAccess;

import java.util.Set;

public interface RoleService {
    /**
     * 给角色赋予某个权限
     * @param roleAccess
     * @return
     */
    boolean giveAccess(RoleAccess roleAccess);

    /**
     * 从某个角色移除某个权限
     * @param rid
     * @param aid
     * @return
     */
    boolean removeAccess(int rid, int aid);

    Role getRole(int rid);

    int addRole(Role role);

    /**
     * 获取角色所属的所有权限
     * @param rid
     * @return
     */
    Set<Access> getAllAccesses(int rid);
}

