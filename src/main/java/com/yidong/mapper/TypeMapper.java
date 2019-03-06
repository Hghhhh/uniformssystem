package com.yidong.mapper;

import com.yidong.model.Type;

import java.util.List;

public interface TypeMapper {

    List<Type> selectBigType();

    List<Type> selectSmallType(int bigTypeId);



    List<String> selectSchoolName(int smallTypeId);
}
