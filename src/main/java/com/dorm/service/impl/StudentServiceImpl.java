package com.dorm.service.impl;

import com.dorm.dao.StudentDao;
import com.dorm.entity.Student;
import com.dorm.service.StudentService;
import com.dorm.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    @Override
    public void randomCreateStudent() {
        int num = 100;
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setName(StringUtil.getRandomString(4));
            student.setGender(new Random().nextInt(2));
            student.setDormName("");
            String studentID = "2001210" + num;
            student.setStudentID(studentID);
            num++;
            student.setVerifyCode(StringUtil.getRandomString(6));
            studentDao.save(student);
        }
    }

    @Override
    public void handleSelectForm(String buildingID, int gender, List<String> studentIDs) {

    }
}
