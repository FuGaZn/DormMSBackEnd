package com.dorm.utils.vo;

import com.dorm.entity.Dorm;
import com.dorm.entity.Student;

import javax.persistence.Column;

public class StudentVO {
    String studentID;
    String name;
    String dormName;
    String building;
    int floor;
    int gender;
    String genderShow = "女";
    String verifyCode;

    //必须要有一个无参构造器，否则controller无法自动把json转化为这个对象
    public StudentVO() {
    }

    public StudentVO(Student student, Dorm dorm) {
        this.studentID = student.getStudentID();
        this.verifyCode = student.getVerifyCode();
        this.name = student.getName();
        this.gender = student.getGender();
        if (this.gender == 1)
            this.genderShow = "男";
        this.dormName = student.getDormName();
        if (dorm!=null){
            this.building = dorm.getBuilding();
            this.floor = dorm.getFloor();
        }
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
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

    public String getGenderShow() {
        return genderShow;
    }

    public void setGenderShow(String genderShow) {
        this.genderShow = genderShow;
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
}
