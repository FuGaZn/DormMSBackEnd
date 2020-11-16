package com.dorm.dao;

import com.dorm.entity.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormDao extends JpaRepository<Dorm, Long> {

    List<Dorm> findAllByBuilding(String building);
}
