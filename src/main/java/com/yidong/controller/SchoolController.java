package com.yidong.controller;


import com.yidong.model.SchoolWithThreeType;
import com.yidong.model.SchoolWithTwoType;
import com.yidong.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value="/schoolName")
    public List<String> getSchoolName(@RequestParam String schoolName){
      return schoolService.selectSchoolName(schoolName);
    }


    @RequestMapping(value="/school")
    public List<SchoolWithThreeType> getSchool(){
       // return schoolService.selectSchool();
     return removeEmpytyChildren(schoolService.selectSchool());
    }


    /**
     * 去掉返回的元素中存在学校是空或二级分类是空的元素
     * @param schoolWithThreeTypes
     * @return
     */
    public List<SchoolWithThreeType> removeEmpytyChildren(List<SchoolWithThreeType> schoolWithThreeTypes){
        SchoolWithThreeType schoolWithThreeType = null;

      for(Iterator i = schoolWithThreeTypes.iterator();i.hasNext(); ){
          schoolWithThreeType = (SchoolWithThreeType) i.next();
            if(schoolWithThreeType.getChildren()!=null&&!schoolWithThreeType.getChildren().isEmpty()){
                SchoolWithTwoType schoolWithTwoType = null;
                boolean flag =true;
                //去掉二级分类中空的学校的元素
                for(Iterator ii = schoolWithThreeType.getChildren().iterator();ii.hasNext();){
                    schoolWithTwoType = (SchoolWithTwoType) ii.next();
                    if(schoolWithTwoType.getChildren()==null||schoolWithTwoType.getChildren().isEmpty()){
                       ii.remove();
                       flag = false;
                    }
                }
                //去掉一级分类中二级分类是空的元素
                if(!flag&&schoolWithThreeType.getChildren().isEmpty()){
                    i.remove();
                }
            }
            else{
                //去掉一级分类中二级分类是空的元素
                i.remove();
            }
        }
        return schoolWithThreeTypes;
    }
}
