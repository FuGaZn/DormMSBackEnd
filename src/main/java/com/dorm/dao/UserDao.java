package com.dorm.dao;

import com.dorm.entity.User;
import com.dorm.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUid(int uid);

    User findByName(String name);

    User findByWorkerID(String workerID);

    List<User> findAll();
}
