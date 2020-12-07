package com.dorm.service;

import com.dorm.entity.Student;
import com.dorm.utils.vo.SelectForm;

import java.util.List;

public interface StudentService {
    public void addOrUpdateStudent(Student student);

    List<Student> findAllStudents();

    List<Student> findAllStudentsByDormName(String dormName);

    Student findByStudentID(String studentID);

    void randomCreateStudent();

    void handleSelectForm(String buildingID, int gender,String firstStudent, List<String> studentIDs);

}
