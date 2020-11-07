package com.dorm.dao;

import com.dorm.entity.RoleAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleAccessDao extends JpaRepository<RoleAccess,Long> {
    Set<RoleAccess> findAllByRoleId(int role_id);

    void deleteByRoleIdAndAccessId(int rid, int aid);
}
