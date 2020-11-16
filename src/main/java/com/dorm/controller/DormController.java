package com.dorm.controller;

import com.dorm.entity.Building;
import com.dorm.entity.Dorm;
import com.dorm.entity.Student;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.service.impl.StudentServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.vo.BuildingVO;
import com.dorm.utils.vo.DormVO;
import com.dorm.utils.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    DormServiceImpl dormService;
    @Autowired
    StudentServiceImpl studentService;

    @ResponseBody
    @PostMapping("/building/add")
    public Msg addBuilding(@RequestBody Building building){
        System.out.println(building);
        Msg msg = new Msg();
        dormService.addBuilding(building);
        msg.setCode(20000);
        return msg;
    }

    @ResponseBody
    @PostMapping("/add")
    public Msg addDorm(@RequestBody DormVO dormVO){
        Msg msg = new Msg();
        Dorm dorm = new Dorm(dormVO);
        dormService.addOrUpdateDorm(dorm);
        msg.setCode(20000);
        return msg;
    }

    @ResponseBody
    @GetMapping("/building/list")
    public Msg listBuildings(){
        Msg msg = new Msg();
        msg.setCode(20000);

        List<Building> buildings = dormService.findAllBuildings();
        List<BuildingVO> buildingVOS = new ArrayList<>();
        for (Building b: buildings){
            List<Dorm> allDorms = dormService.findAllDormsByBuilding(b.getBuildingID());
            BuildingVO buildingVO = new BuildingVO(b,allDorms);
            buildingVOS.add(buildingVO);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("buildings", buildingVOS);
        msg.setData(map);
        return msg;
    }

    @ResponseBody
    @GetMapping("/student/list")
    public Msg listStudents(String dormName){
        System.out.println(dormName);
        Msg msg = new Msg();
        msg.setCode(20000);
        List<StudentVO> studentVOS = new ArrayList<>();
        List<Student> students = studentService.findAllStudentsByDormName(dormName);
        System.out.println(students.size());
        for (Student s: students){
            StudentVO studentVO = new StudentVO(s,null);
            studentVOS.add(studentVO);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("students", studentVOS);
        msg.setData(map);
        return msg;
    }

    @ResponseBody
    @GetMapping("/list")
    public Msg listDormsOfBuilding(String buildingID){
        Msg msg = new Msg();
        msg.setCode(20000);
        Map<String, Object> data = new HashMap<>();
        List<DormVO> list = new ArrayList<>();

        List<Dorm> originDorms = dormService.findAllDormsByBuilding(buildingID);
        for (Dorm d: originDorms){
            DormVO dormVO = new DormVO(d);
            list.add(dormVO);
        }
        BuildingVO buildingVO = new BuildingVO(dormService.findBuildingByBuildingID(buildingID),null);
        data.put("dorms", list);
        data.put("buildingData", buildingVO);
        msg.setData(data);
        return msg;
    }
}
