package com.dorm.entity;

import javax.persistence.*;

@Entity
@Table
public class SubmitBackMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    int code;
    @Column
    String message;

    @Column
    String studentID;

    public SubmitBackMsg() {
    }

    public SubmitBackMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
