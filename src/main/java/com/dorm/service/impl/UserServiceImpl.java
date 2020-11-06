package com.dorm.service.impl;

import com.dorm.dao.RoleDao;
import com.dorm.dao.RoleUserDao;
import com.dorm.dao.UserDao;
import com.dorm.entity.Access;
import com.dorm.entity.Role;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.RoleService;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleUserDao roleUserDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    RoleService roleService;
    @Override
    public User getUser(String name) {
        return userDao.findByName(name);
    }

    @Override
    public boolean giveRole(RoleUser roleUser) {
        roleUserDao.save(roleUser);
        return true;
    }

    @Override
    public Set<Role> getAllRoles(int uid) {
        Set<RoleUser> roleUserSet = roleUserDao.findAllByUser_id(uid);
        Set<Role> roles = new HashSet<>();
        for (RoleUser roleUser: roleUserSet){
            Role role = roleDao.findByRid(roleUser.getRole_id());
            if (role!=null)
                roles.add(role);
        }
        return roles;
    }

    @Override
    public boolean removeRole(int uid, int rid) {
        roleUserDao.deleteByUser_idAndRole_id(uid,rid);
        return true;
    }

    @Override
    public int addUser(User user) {
        return userDao.save(user).getUid();
    }

    @Override
    public Set<Access> getAllAccesses(int uid) {
        Set<Role> roles = getAllRoles(uid);
        Set<Access> accessSet = new HashSet<>();
        for (Role role: roles){
            Set<Access> accessSet1 = roleService.getAllAccesses(role.getRid());
            accessSet.addAll(accessSet1);
        }
        return accessSet;
    }
}
