package com.dorm.controller;

import com.dorm.entity.Dorm;
import com.dorm.entity.Student;
import com.dorm.service.DormService;
import com.dorm.service.StudentService;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.service.impl.StudentServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.mq.MqProducer;
import com.dorm.utils.vo.SelectForm;
import com.dorm.utils.vo.StudentVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/student")
public class StudentController {
    @Autowired
    DormServiceImpl dormService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    MqProducer producer;

    @ResponseBody
    @GetMapping("/get")
    public Msg getStudent(String studentID){
        Msg msg = new Msg();
        msg.setCode(20000);
        Student student = studentService.findByStudentID(studentID);
        StudentVO studentVO = null;
        if (student!=null) {
            studentVO = new StudentVO(student, null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("student", studentVO);
        msg.setData(map);
        return msg;
    }

    @ResponseBody
    @GetMapping("/random")
    public Msg randomCreateStudent(){
        Msg msg = new Msg();
        msg.setCode(20000);
        studentService.randomCreateStudent();
        return msg;
    }

    @ResponseBody
    @PostMapping("/add")
    public Msg addStudent(@RequestBody StudentVO studentVO){
        Msg msg = new Msg();
        msg.setCode(20000);

        if (null == studentVO.getDormName() || studentVO.getDormName().trim().equals("")){
            Student student = new Student(studentVO,null);
            studentService.addOrUpdateStudent(student);
        }

        return msg;
    }

    @ResponseBody
    @GetMapping("/list")
    public Msg listStudents(){
        Msg msg = new Msg();
        msg.setCode(20000);

        List<Student> students = studentService.findAllStudents();

        List<StudentVO> studentVOS = new ArrayList<>();
        for (Student s: students){
            Dorm dorm = null;
            if (s.getDormName()!=null&& !s.getDormName().equals(""))
                dorm = dormService.findByDormName(s.getDormName());
            StudentVO studentVO = new StudentVO(s,dorm);
            studentVOS.add(studentVO);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("students",studentVOS);
        msg.setData(map);
        return msg;
    }

    @ResponseBody
    @PostMapping("/submit")
    public Msg handleSelectForm(@RequestBody SelectForm selectForm){
        Msg msg = new Msg();
        msg.setCode(20000);
        try {
        //    System.out.println(selectForm);
            producer.sendMessage(selectForm);
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
