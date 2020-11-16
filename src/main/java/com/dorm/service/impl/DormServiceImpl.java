package com.dorm.service.impl;

import com.dorm.dao.BuildingDao;
import com.dorm.dao.DormDao;
import com.dorm.entity.Building;
import com.dorm.entity.Dorm;
import com.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormServiceImpl implements DormService {
    @Autowired
    BuildingDao buildingDao;
    @Autowired
    DormDao dormDao;
    @Override
    public void addBuilding(Building building) {
        buildingDao.save(building);
    }

    @Override
    public List<Building> findAllBuildings(){
        return buildingDao.findAll();
    }

    @Override
    public List<Dorm> findAllDormsByBuilding(String building) {
        return dormDao.findAllByBuilding(building);
    }
}
