package com.dorm.service.impl;


import com.dorm.dao.AccessDao;
import com.dorm.dao.RoleAccessDao;
import com.dorm.dao.RoleDao;
import com.dorm.entity.Access;
import com.dorm.entity.Role;
import com.dorm.entity.RoleAccess;
import com.dorm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    RoleAccessDao roleAccessDao;
    @Autowired
    AccessDao accessDao;

    @Override
    public boolean giveAccess(RoleAccess roleAccess) {
        roleAccessDao.save(roleAccess);
        return true;
    }

    @Override
    public boolean removeAccess(int rid, int aid) {
        roleAccessDao.deleteByRoleIdAndAccessId(rid,aid);
        return true;
    }

    @Override
    public Role getRole(int rid) {
        return roleDao.findByRid(rid);
    }

    @Override
    public int addRole(Role role) {
        return roleDao.save(role).getRid();
    }

    @Override
    public Set<Access> getAllAccesses(int rid) {
        Set<RoleAccess> roleAccessSet = roleAccessDao.findAllByRoleId(rid);
        Set<Access> accessSet = new HashSet<>();
        for (RoleAccess r: roleAccessSet){
            accessSet.add(accessDao.findByAid(r.getAccessId()));
        }
        return accessSet;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.findByName(name);
    }
}
