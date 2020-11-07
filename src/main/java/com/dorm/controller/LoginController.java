package com.dorm.controller;

import com.dorm.dao.UserDao;
import com.dorm.entity.User;
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
    UserDao userDao;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(@RequestBody User user){
        System.out.println(user.getName());
        Map<String,Object> response = new HashMap<>();
        Map<String,Object> responseData = new HashMap<>();
        responseData.put("token",1);
        response.put("code",20000);
        response.put("data", responseData);
        return response;
    }

    @ResponseBody
    @GetMapping(value = "/user/info")
    public Map info() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        Set<String> roles = new HashSet<>();
        roles.add("student");
        responseData.put("roles",roles);
        responseData.put("name","Super admin");
        responseData.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseInfo.put("code",20000);
        responseInfo.put("msg","登录成功");
        responseInfo.put("data",responseData);
        return responseInfo;
    }

    @PostMapping("/user/logout")
    @ResponseBody
    public Map logout(){
        Map<String, Object> responseInfo = new HashMap<>();
        responseInfo.put("code", 20000);
        
        return responseInfo;
    }
}
