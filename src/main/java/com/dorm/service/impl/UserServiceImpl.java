package com.dorm.service.impl;

import com.dorm.dao.UserDao;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
}
