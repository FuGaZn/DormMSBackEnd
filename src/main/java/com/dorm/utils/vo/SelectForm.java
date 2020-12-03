package com.dorm.utils.vo;

import com.dorm.entity.Student;

import java.util.List;

public class SelectForm {
    String buildingID;
    List<String> studentIDs;
    int gender;

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public List<String> getStudentIDs() {
        return studentIDs;
    }

    public void setStudentIDs(List<String> studentIDs) {
        this.studentIDs = studentIDs;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SelectForm{" +
                "buildingID='" + buildingID + '\'' +
                ", studentIDs=" + studentIDs +
                ", gender=" + gender +
                '}';
    }
}
