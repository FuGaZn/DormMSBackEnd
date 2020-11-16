package com.dorm.service;

import com.dorm.entity.Student;

import java.util.List;

public interface StudentService {
    public void addOrUpdateStudent(Student student);

    List<Student> findAllStudents();

    List<Student> findAllStudentsByDormName(String dormName);
    Student findByStudentID(String studentID);



}
