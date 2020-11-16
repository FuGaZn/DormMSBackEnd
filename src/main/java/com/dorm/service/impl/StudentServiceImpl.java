package com.dorm.service.impl;

import com.dorm.dao.StudentDao;
import com.dorm.entity.Student;
import com.dorm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public void addOrUpdateStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findAllStudentsByDormName(String dormName) {
        return studentDao.findAllByDormName(dormName);
    }

    @Override
    public Student findByStudentID(String studentID) {
        return studentDao.findByStudentID(studentID);
    }
}
