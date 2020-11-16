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

    @Override
    public Building findBuildingByBuildingID(String buildingID) {
        return buildingDao.findByBuildingID(buildingID);
    }

    @Override
    public void addOrUpdateDorm(Dorm dorm) {
        dormDao.save(dorm);
    }
    @Override
    public Dorm findByDormName(String dormName) {
        return dormDao.findByDormName(dormName);
    }

    @Override
    public Dorm findByDid(int id) {
        return dormDao.findByDid(id);
    }
}
