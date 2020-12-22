package com.dorm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dorm.entity.Student;
import com.dorm.entity.User;

import java.util.Date;

public class TokenUtil {

    public static String getUserToken(User user){
        String token = JWT.create().withClaim("uid",user.getUid())
                .withClaim("name",user.getName())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
    public static String getStudentToken(Student student){
        String token = JWT.create().withClaim("uid", student.getSid())
                .sign(Algorithm.HMAC256(student.getVerifyCode()));
        return token;
    }
}
