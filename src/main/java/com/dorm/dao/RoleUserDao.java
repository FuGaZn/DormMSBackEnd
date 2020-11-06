package com.dorm.dao;

import com.dorm.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleUserDao extends JpaRepository<RoleUser, Long> {

    Set<RoleUser> findAllByUser_id(int user_id);

    void deleteByUser_idAndRole_id(int uid, int rid);
}
