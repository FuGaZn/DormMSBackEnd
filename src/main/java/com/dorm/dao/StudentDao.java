package com.dorm.dao;

import com.dorm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    @Override
    List<Student> findAll();

    List<Student> findAllByDormName(String dormName);

    Student findByStudentID(String studentID);

}
