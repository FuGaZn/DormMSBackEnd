package com.dorm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dorm.entity.User;

import java.util.Date;

public class TokenUtil {

    public static String getUserToken(User user){

        String token = JWT.create().withClaim("uid",user.getUid())
                .withClaim("name",user.getName())
                .withClaim("password", user.getPassword())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
