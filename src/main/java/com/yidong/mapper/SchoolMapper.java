package com.yidong.mapper;

import com.yidong.model.SchoolWithThreeType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolMapper {

    List<String> selectSchoolName( @Param("schoolName")String schoolName);

    List<SchoolWithThreeType> selectSchool();
}
