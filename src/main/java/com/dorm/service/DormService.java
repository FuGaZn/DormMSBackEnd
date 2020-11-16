package com.dorm.service;

import com.dorm.dao.BuildingDao;
import com.dorm.entity.Building;
import com.dorm.entity.Dorm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DormService {

    public void addBuilding(Building building);
    public List<Building> findAllBuildings();

    public List<Dorm> findAllDormsByBuilding(String building);
}
