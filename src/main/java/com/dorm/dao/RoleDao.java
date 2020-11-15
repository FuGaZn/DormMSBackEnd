package com.dorm.dao;

import com.dorm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByRid(int rid);

    Role findByName(String name);
}
