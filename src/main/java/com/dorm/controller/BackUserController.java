package com.dorm.controller;

import com.dorm.annotation.UserLoginToken;
import com.dorm.entity.Role;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.impl.RoleServiceImpl;
import com.dorm.service.impl.UserServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/user/back")
public class BackUserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    @ResponseBody
    @UserLoginToken
    @PostMapping("/modify")
    public Msg modifyUserRoles(@RequestBody UserVO userVO){
        Msg msg = new Msg();

        List<String> roleStringSet = userVO.getRoles();
        User user = userService.getUserById(userVO.getUid());
        Set<RoleUser> roleUsers = user.getRoleUsers();
        Set<RoleUser> newRoleUsers = new HashSet<>();
        for (RoleUser ru: roleUsers){
            if (ru.getStatus() == 0){
                String ru_name = roleService.getRole(ru.getRoleId()).getName();
                if (roleStringSet.contains(ru_name)){
                    System.out.println("1 "+ru.toString());
                    newRoleUsers.add(ru);
                    roleStringSet.remove(ru_name);
                }
            }
        }
        if (roleStringSet.size()!=0){
            for (String ru: roleStringSet){
                RoleUser roleUser = new RoleUser();
                roleUser.setUserId(user.getUid());
                roleUser.setRoleId(roleService.getRoleByName(ru).getRid());
                newRoleUsers.add(roleUser);
            }
        }
        System.out.println(newRoleUsers.size());
        userService.updateRoles(user.getUid(), newRoleUsers);
        msg.setCode(20000);
        return msg;
    }

    @ResponseBody
    @PostMapping("/add")
    public Msg addUser(@RequestBody UserVO userVO){
        Msg msg = new Msg();

        User user = new User();
        user.setName(userVO.getName());
        user.setWorkerID(userVO.getWorkerID());
        user.setPassword("111111");
        Set<RoleUser> roleUsers = new HashSet<>();
        user = userService.register(user);
        for (String role_string: userVO.getRoles()){
            Role role = roleService.getRoleByName(role_string);
            RoleUser roleUser = new RoleUser();
            roleUser.setUserId(user.getUid());
            roleUser.setRoleId(role.getRid());
            roleUsers.add(roleUser);
        }
        user.setRoleUsers(roleUsers);
        userService.updateUser(user);
   //     System.out.println(userVO.toString());
        msg.setCode(20000);
        return msg;
    }

    @ResponseBody
    @GetMapping("/list")
    public Msg listUsers(){
        Msg msg = new Msg();
        msg.setCode(20000);
        Map<String, Object> map = new HashMap<>();
        Set<UserVO> userVOSet = new HashSet<>();

        List<User> users = userService.getAllUsers();
        for (User u: users){
            UserVO userVO = new UserVO();
            userVO.setUid(u.getUid());
            userVO.setName(u.getName());
            userVO.setWorkerID(u.getWorkerID());
            userVO.setLastLoginTime("2020/11/15 20:56:49");
            Set<RoleUser> roleUsers = userService.getAllRoleUsers(u.getUid());
            List<String> roles = new ArrayList<>();
            for (RoleUser ru: roleUsers){
                if (ru.getStatus() == 0)
                    roles.add(roleService.getRole(ru.getRoleId()).getName());
            }
            userVO.setRoles(roles);
            userVOSet.add(userVO);
        }
        map.put("users", userVOSet);
        msg.setData(map);
        return msg;
    }
}
