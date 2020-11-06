package com.dorm.service.impl;


import com.dorm.dao.AccessDao;
import com.dorm.entity.Access;
import com.dorm.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    AccessDao accessDao;
    @Override
    public boolean addAccess(Access access) {
        accessDao.save(access);
        return true;
    }
}
