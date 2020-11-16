package com.dorm.controller;

import com.dorm.entity.Building;
import com.dorm.entity.Dorm;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.utils.Msg;
import com.dorm.utils.vo.BuildingVO;
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
}
