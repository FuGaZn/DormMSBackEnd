package com.dorm.utils.vo;

import com.dorm.entity.Student;

import java.util.List;
import java.util.Objects;

public class SelectForm {
    String key;
    String buildingID;
    String firstStudent;
    List<String> studentIDs;
    int gender;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFirstStudent() {
        return firstStudent;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectForm form = (SelectForm) o;
        return Objects.equals(key, form.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
