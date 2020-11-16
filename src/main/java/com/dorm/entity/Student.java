package com.dorm.entity;

import com.dorm.utils.vo.StudentVO;

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


    @Column
    String dormName;

    @Column
    int gender;

    public Student() {

    }

    public Student(StudentVO student,Dorm dorm) {
        this.studentID = student.getStudentID();
        this.name = student.getName();
        this.gender = student.getGender();
        this.dormName = student.getDormName();
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", dormName='" + dormName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
