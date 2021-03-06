package com.dorm.service;


import com.dorm.entity.Access;
import com.dorm.entity.Role;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface UserService {
     User getUser(String name);

     User getUserById(int id);
    /**
     * 为用户赋予某个角色
     * @param roleUser
     * @return
     */
    boolean giveRole(RoleUser roleUser);

    /**
     * 获取用户所属的所有角色
     * @param uid
     * @return
     */
    Set<Role> getAllRoles(int uid);

    /**
     * 移除用户的某个角色
     * @param uid
     * @param rid
     * @return
     */
    boolean removeRole(int uid, int rid);

    int addUser(User user);

    void updateUser(User user);
    /**
     * 获取用户的权限列表
     * @param uid
     * @return
     */
    Set<Access> getAllAccesses(int uid);

    User register(User user);

    boolean login(User user);

    List<User> getAllUsers();

    boolean updateRoles(int uid, Set<RoleUser> roleUsers);

    Set<RoleUser> getAllRoleUsers(int uid);
}
