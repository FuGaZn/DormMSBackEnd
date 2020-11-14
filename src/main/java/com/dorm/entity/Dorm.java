package com.dorm.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int did;

    @Column
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dorm_id")
    Set<Student> students;

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
