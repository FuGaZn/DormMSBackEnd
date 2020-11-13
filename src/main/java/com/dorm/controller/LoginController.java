package com.dorm.controller;

import com.auth0.jwt.JWT;
import com.dorm.annotation.PassToken;
import com.dorm.annotation.UserLoginToken;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.RoleService;
import com.dorm.service.UserService;
import com.dorm.service.impl.RoleServiceImpl;
import com.dorm.service.impl.UserServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    @PassToken
    public Msg login(@RequestBody User user){
        Msg msg = new Msg();
        if (userService.login(user)){
            Map<String,Object> responseData = new HashMap<>();
            User user1 = userService.getUser(user.getName());
            responseData.put("token", TokenUtil.getUserToken(user1));
            msg.setCode(20000);
            msg.setInfo("登陆成功");
            msg.setData(responseData);
        }else{
            System.out.println("login error");
            msg.setCode(50000);
        }
        return msg;
    }

    @ResponseBody
    @UserLoginToken
    @GetMapping(value = "/user/info")
    public Msg info(@RequestHeader("X-token") String token) {
        System.out.println(token);
        int uid = JWT.decode(token).getClaim("uid").asInt();
        User user = userService.getUserById(uid);
        Msg msg = new Msg();
        HashMap<String, Object> responseData = new HashMap<>();
        Set<String> roles = new HashSet<>();
        for (RoleUser roleUser: user.getRoleUsers()){
            roles.add(roleService.getRole(roleUser.getRoleId()).getName());
        }
        responseData.put("roles",roles);
        responseData.put("name",user.getName());
        responseData.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        msg.setCode(20000);
        msg.setInfo("登陆成功");
        msg.setData(responseData);
        return msg;
    }

    @PostMapping("/user/logout")
    @ResponseBody
    public Msg logout(String token){
        System.out.println("logout "+token);
        Msg msg = new Msg();
        msg.setCode(20000);
        return msg;
    }

    @PostMapping("/user/register")
    @ResponseBody
    public Msg register(User user){
        User user1 = userService.getUser(user.getName());
        if (user1!=null){

        }else{
            User user2 = userService.register(user);
        }
        return null;
    }
}
