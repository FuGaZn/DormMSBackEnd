package com.dorm.dao;

import com.dorm.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingDao extends JpaRepository<Building, Long> {
    @Override
    List<Building> findAll();
}
