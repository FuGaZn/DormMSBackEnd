package com.dorm.entity;

import com.dorm.utils.vo.DormVO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int did;

    @Column(unique = true)
    String dormName;

    //所属楼 13
    @Column
    String building;

    //所属楼层 5
    @Column
    int floor;

    @Column
    int totalBed;

    @Column
    int emptyBed;

    @Column
    int gender;

    public Dorm() {
    }

    public Dorm(DormVO dormVO) {
        this.dormName = dormVO.getDormName();
        this.building = dormVO.getBuilding();
        this.floor = dormVO.getFloor();
        this.totalBed = dormVO.getTotalBed();
        this.emptyBed = dormVO.getEmptyBed();
        this.gender = dormVO.getGender();
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
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
}
