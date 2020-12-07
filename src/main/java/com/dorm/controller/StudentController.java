package com.dorm.controller;

import com.dorm.entity.Dorm;
import com.dorm.entity.Student;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.service.impl.StudentServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.mq.MqProducer;
import com.dorm.utils.vo.SelectForm;
import com.dorm.utils.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
       // studentService.randomCreateStudent();
//        for (int i = 0; i < 25; i++) {
//            Dorm dorm = new Dorm();
//            dorm.setBuilding("5");
//            String name = "5";
//            int floor = (new Random().nextInt(5) + 1);
//            name += "" + floor;
//            name += "" + (new Random().nextInt(5));
//            name += "" + new Random().nextInt(10);
//            dorm.setDormName(name);
//            dorm.setEmptyBed(new Random().nextInt(4)+2);
//            dorm.setGender(new Random().nextInt(2));
//            dorm.setFloor(floor);
//            dorm.setTotalBed(dorm.getEmptyBed());
//            dormService.addOrUpdateDorm(dorm);
//        }
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
            producer.sendMessage(selectForm);
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}

