package com.yidong.service.impl;

import com.yidong.mapper.SchoolMapper;
import com.yidong.model.SchoolWithThreeType;
import com.yidong.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<String> selectSchoolName(String schoolName) {
        return schoolMapper.selectSchoolName(schoolName);
    }

    @Override
    public List<SchoolWithThreeType> selectSchool() {
        return schoolMapper.selectSchool();
    }
}
