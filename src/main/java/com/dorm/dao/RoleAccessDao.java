package com.dorm.dao;

import com.dorm.entity.RoleAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleAccessDao extends JpaRepository<RoleAccess,Long> {
    Set<RoleAccess> findAllByRole_id(int role_id);

    void deleteByRole_idAndAccess_id(int rid, int aid);
}
