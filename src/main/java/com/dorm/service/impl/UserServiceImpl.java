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
import com.dorm.utils.MyMD5;
import com.dorm.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
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
    public User getUser(String workerID) {
        return userDao.findByName(workerID);
    }

    @Override
    public boolean giveRole(RoleUser roleUser) {
        roleUserDao.save(roleUser);
        return true;
    }

    @Override
    public Set<Role> getAllRoles(int uid) {
        Set<RoleUser> roleUserSet = roleUserDao.findAllByUserId(uid);
        Set<Role> roles = new HashSet<>();
        for (RoleUser roleUser: roleUserSet){
            Role role = roleDao.findByRid(roleUser.getRoleId());
            if (role!=null)
                roles.add(role);
        }
        return roles;
    }

    @Override
    public boolean removeRole(int uid, int rid) {
        roleUserDao.deleteByUserIdAndRoleId(uid,rid);
        return true;
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
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

    @Override
    public User register(User user) {
        user.setSalt(StringUtil.getRandomString(user.getPassword().length()));
        user.setPassword(MyMD5.encrypt(user.getPassword()+user.getSalt()));
        user.setUid(userDao.save(user).getUid());
        return user;
    }

    @Override
    public boolean login(User user) {
        User user1 = getUser(user.getName());
        if(user1 == null)
            return false;
        String secretedPwd = MyMD5.encrypt(user.getPassword()+user1.getSalt());
        if (secretedPwd.equals(user1.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        return userDao.findByUid(id);
    }
}
