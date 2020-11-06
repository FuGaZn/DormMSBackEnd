package com.dorm.controller;

import com.dorm.dao.UserDao;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(String username, String password){
        System.out.println(username);
        System.out.println(password);

        User user = userDao.findByUid(1);
        Set<RoleUser> roleUsers = user.getRoleUsers();
        System.out.println(roleUsers==null);
        System.out.println(roleUsers.size());

        for (RoleUser r: roleUsers)
            System.out.println(r);
        return "";
    }
}
