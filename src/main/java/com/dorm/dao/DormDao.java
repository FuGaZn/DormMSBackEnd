package com.dorm.dao;

import com.dorm.entity.Dorm;
import com.dorm.service.DormService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormDao extends JpaRepository<Dorm, Long> {

    List<Dorm> findAllByBuilding(String building);

    Dorm findByDid(int did);
    Dorm findByDormName(String dormName);

    List<Dorm> findAllByGenderAndEmptyBed(int gender, int empty);

    List<Dorm> findAllByGenderAndEmptyBedGreaterThan(int gender, int empty);
}
