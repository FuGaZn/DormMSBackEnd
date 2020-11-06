package com.dorm.dao;


import com.dorm.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessDao extends JpaRepository<Access, Long> {

    Access findByAid(int aid);

}
