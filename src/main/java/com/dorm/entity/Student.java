package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;
    //学号
    @Column
    String studentID;
    @Column
    String name;

    @Column(name = "dorm_id")
    int dorm;

    @Column
    String dormName;

    @Column
    int gender;

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDorm() {
        return dorm;
    }

    public void setDorm(int dorm) {
        this.dorm = dorm;
    }
}
