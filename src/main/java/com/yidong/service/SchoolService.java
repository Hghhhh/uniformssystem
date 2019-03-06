package com.yidong.service;

import com.yidong.model.SchoolWithThreeType;

import java.util.List;

public interface SchoolService {

    List<String> selectSchoolName(String schoolName);

    List<SchoolWithThreeType> selectSchool();
}
