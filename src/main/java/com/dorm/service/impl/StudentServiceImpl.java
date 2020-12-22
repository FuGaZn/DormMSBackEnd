package com.dorm.service.impl;

import com.dorm.dao.DormDao;
import com.dorm.dao.StudentDao;
import com.dorm.dao.SubmitBackMsgDao;
import com.dorm.entity.Dorm;
import com.dorm.entity.Student;
import com.dorm.entity.SubmitBackMsg;
import com.dorm.service.StudentService;
import com.dorm.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    DormDao dormDao;
    @Autowired
    SubmitBackMsgDao submitBackMsgDao;


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
    public void handleSelectForm(String buildingID, int gender, String firstStudent, List<String> studentIDs) {
        SubmitBackMsg msg = submitBackMsgDao.findByStudentID(firstStudent);
        if (msg == null) {
            msg = new SubmitBackMsg();
            msg.setCode(20000);
            msg.setStudentID(firstStudent);
            msg.setId(submitBackMsgDao.save(msg).getId());
        }
        String message = "";
        List<Student> students = new ArrayList<>();
        /*
         *==================================
         * 判断是否有学生已被分配宿舍
         * =================================
         */
        {
            Student student = findByStudentID(firstStudent);
            students.add(student);
            if (!student.getDormName().equals("")) {
                msg.setCode(50000);
                message = firstStudent + " ";
            }
        }
        for (String id : studentIDs) {
            Student student = findByStudentID(id);
            if (!student.getDormName().equals("")) {
                msg.setCode(50000);
                message += (firstStudent + " ");
            }
            students.add(student);
        }
        if (msg.getCode() == 50000) {
            msg.setMessage("学生" + message + "已被分配宿舍");
            submitBackMsgDao.save(msg);
            return;
        }

        int numOfStu = 1 + studentIDs.size();
        List<Dorm> dormList = dormDao.findAllByGenderAndEmptyBed(gender, numOfStu);
        if (dormList == null || dormList.size() == 0) {
            dormList = dormDao.findAllByGenderAndEmptyBedGreaterThan(gender, numOfStu);
        }

        /*
         *==================================
         * 没有宿舍可供分配
         * =================================
         */
        if (dormList == null || dormList.size() == 0) {
            msg.setCode(50000);
            msg.setMessage("空床位" + numOfStu + "个以上的宿舍已被分配完。");
            submitBackMsgDao.save(msg);
            return;
        }

        boolean buildingExist = false;
        Dorm dorm = null;
        for (Dorm d : dormList) {
            if (d.getBuilding().equals(buildingID)) {
                buildingExist = true;
                dorm = d;
                break;
            }
        }
        /*
         *==================================
         * 学生心仪的宿舍楼不存在空宿舍，随机分配一个宿舍楼
         * =================================
         */
        if (buildingExist == false) {
            dorm = dormList.get(0);
        }
        dorm.setEmptyBed(dorm.getEmptyBed() - numOfStu);
        for (Student student : students) {
            student.setDormName(dorm.getDormName());
            studentDao.save(student);
        }
        dormDao.save(dorm);
        msg.setCode(20000);
        msg.setMessage("宿舍分配成功，您的宿舍是" + dorm.getDormName());
        submitBackMsgDao.save(msg);
    }
}
