package com.yidong.controller;

import com.yidong.model.Type;
import com.yidong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/bigTypes")
    public List<Type> getBigType() {
        return typeService.selectBigType();
    }

    @RequestMapping("/smallTypes")
    public List<Type> getSmallType(@RequestParam int typeId) {
        return typeService.selectSmallType(typeId);
    }

    /*@RequestMapping("/schoolName")
    public List<String> getSchoolName(@RequestParam int smallTypeId){
        return typeService.selectSchoolName(smallTypeId);
    }*/

}
