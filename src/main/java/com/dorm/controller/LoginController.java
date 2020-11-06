package com.dorm.controller;

import com.dorm.dao.UserDao;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody User user){
        System.out.println(user.getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("code",20000);
        jsonObject.accumulate("success", 1);
        jsonObject.accumulate("token","test");
        return jsonObject;
    }
}
