package com.dorm.utils.vo;

import com.dorm.entity.Building;
import com.dorm.entity.Dorm;

import java.util.List;

public class BuildingVO {
    String buildingID;
    int floors;
    int dormTotal;
    int bedTotal;
    int dormEmpty;
    int bedEmpty;

    public BuildingVO() {
    }

    public BuildingVO(Building building, List<Dorm> allDorms) {
        this.buildingID = building.getBuildingID();
        this.floors = building.getFloors();
        int dormEmpty = 0, bedTotal = 0, bedEmpty = 0;
        if (allDorms != null) {
            this.dormTotal = allDorms.size();
            for (Dorm dorm : allDorms) {
                if (dorm.getEmptyBed() > 0)
                    dormEmpty++;
                bedTotal += dorm.getTotalBed();
                bedEmpty += dorm.getEmptyBed();
            }
            this.dormEmpty = dormEmpty;
            this.bedEmpty = bedEmpty;
            this.bedTotal = bedTotal;
        }

    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getDormTotal() {
        return dormTotal;
    }

    public void setDormTotal(int dormTotal) {
        this.dormTotal = dormTotal;
    }

    public int getBedTotal() {
        return bedTotal;
    }

    public void setBedTotal(int bedTotal) {
        this.bedTotal = bedTotal;
    }

    public int getDormEmpty() {
        return dormEmpty;
    }

    public void setDormEmpty(int dormEmpty) {
        this.dormEmpty = dormEmpty;
    }

    public int getBedEmpty() {
        return bedEmpty;
    }

    public void setBedEmpty(int bedEmpty) {
        this.bedEmpty = bedEmpty;
    }
}
