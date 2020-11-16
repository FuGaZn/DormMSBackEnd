package com.dorm.controller;

import com.dorm.entity.Dorm;
import com.dorm.entity.Student;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.service.impl.StudentServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DormAllocateController {
    @Autowired
    DormServiceImpl dormService;
    @Autowired
    StudentServiceImpl studentService;

    @ResponseBody
    @PostMapping("/dorm/allocate")
    public Msg allocate(String studentID, String dormName){
        Msg msg = new Msg();
        msg.setCode(20000);
        Dorm dorm = dormService.findByDormName(dormName);
        if(dorm == null){
            msg.setCode(50064);
            msg.setMessage("宿舍不存在！");
            return msg;
        }
        if (dorm.getEmptyBed() == 0){
            msg.setCode(50064);
            msg.setMessage("宿舍已满");
            return msg;
        }
        Student student = studentService.findByStudentID(studentID);
        if (student == null){
            msg.setCode(50064);
            msg.setMessage("学生不存在！");
            return msg;
        }
        if (student.getDormName()!=null && student.getDormName().length()!=0){
            msg.setCode(50064);
            msg.setMessage("该学生已有宿舍！");
            return msg;
        }
        student.setDormName(dormName);
        dorm.setEmptyBed(dorm.getEmptyBed()-1);
        studentService.addOrUpdateStudent(student);
        dormService.addOrUpdateDorm(dorm);
        return msg;
    }

    @ResponseBody
    @PostMapping("/dorm/change")
    public Msg change(String studentID, String dormName){
        Msg msg = new Msg();
        msg.setCode(20000);
        Dorm dorm = dormService.findByDormName(dormName);
        if(dorm == null){
            msg.setCode(50064);
            msg.setMessage("宿舍不存在！");
            return msg;
        }
        if (dorm.getEmptyBed() == 0){
            msg.setCode(50064);
            msg.setMessage("宿舍已满");
            return msg;
        }
        Student student = studentService.findByStudentID(studentID);
        if (student == null){
            msg.setCode(50064);
            msg.setMessage("学生不存在！");
            return msg;
        }
        if (student.getDormName()!=null && student.getDormName().length()!=0){
            Dorm dorm1 = dormService.findByDormName(student.getDormName());
            dorm1.setEmptyBed(dorm1.getEmptyBed()+1);
            dormService.addOrUpdateDorm(dorm1);
        }
        student.setDormName(dormName);
        dorm.setEmptyBed(dorm.getEmptyBed()-1);
        studentService.addOrUpdateStudent(student);
        dormService.addOrUpdateDorm(dorm);
        return msg;
    }

    @ResponseBody
    @PostMapping("/dorm/remove")
    public Msg remove(String studentID){
        Msg msg = new Msg();
        msg.setCode(20000);
        Student student = studentService.findByStudentID(studentID);
        if (student == null){
            msg.setCode(50064);
            msg.setMessage("学生不存在");
            return msg;
        }
        if (student.getDormName() == null || student.getDormName().equals("")){
            msg.setCode(50064);
            msg.setMessage("该学生并未分配宿舍");
            return msg;
        }
        String dormName = student.getDormName();
        Dorm dorm = dormService.findByDormName(dormName);
        dorm.setEmptyBed(dorm.getEmptyBed()+1);
        student.setDormName("");
        studentService.addOrUpdateStudent(student);
        dormService.addOrUpdateDorm(dorm);
        return msg;
    }

    @ResponseBody
    @PostMapping("/dorm/exchange")
    public Msg exchange(String id1, String id2){
        Msg msg = new Msg();
        msg.setCode(20000);
        Student student = studentService.findByStudentID(id1);
        if (student == null){
            msg.setCode(50064);
            msg.setMessage("学生1不存在");
            return msg;
        }
        if (student.getDormName() == null || student.getDormName().equals("")){
            msg.setCode(50064);
            msg.setMessage("学生1并未分配宿舍");
            return msg;
        }
        Student student2 = studentService.findByStudentID(id2);

        if (student2 == null){
            msg.setCode(50064);
            msg.setMessage("学生2不存在");
            return msg;
        }
        if (student2.getDormName() == null || student2.getDormName().equals("")){
            msg.setCode(50064);
            msg.setMessage("学生2并未分配宿舍");
            return msg;
        }

        if (student.getGender()!=student2.getGender()){
            msg.setCode(50064);
            msg.setMessage("两个学生性别不同，无法调换宿舍");
            return msg;
        }
        String tmp = student.getDormName();
        student.setDormName(student2.getDormName());
        student2.setDormName(tmp);
        studentService.addOrUpdateStudent(student);
        studentService.addOrUpdateStudent(student2);
        return msg;
    }
}
