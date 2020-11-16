package com.dorm.utils.vo;

import com.dorm.entity.Dorm;

import javax.persistence.Column;

public class DormVO {
    String dormName;

    //所属楼 13
    String building;

    //所属楼层 5
    int floor;

    int totalBed;

    int emptyBed;

    public DormVO() {
    }

    public DormVO(Dorm dorm) {
        this.dormName = dorm.getDormName();
        this.building = dorm.getBuilding();
        this.floor = dorm.getFloor();
        this.totalBed = dorm.getTotalBed();
        this.emptyBed = dorm.getEmptyBed();
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTotalBed() {
        return totalBed;
    }

    public void setTotalBed(int totalBed) {
        this.totalBed = totalBed;
    }

    public int getEmptyBed() {
        return emptyBed;
    }

    public void setEmptyBed(int emptyBed) {
        this.emptyBed = emptyBed;
    }

    @Override
    public String toString() {
        return "DormVO{" +
                "dormName='" + dormName + '\'' +
                ", building='" + building + '\'' +
                ", floor=" + floor +
                ", totalBed=" + totalBed +
                ", emptyBed=" + emptyBed +
                '}';
    }
}
