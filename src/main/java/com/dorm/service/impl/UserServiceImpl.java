package com.dorm.service.impl;

import com.dorm.dao.UserDao;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

}
