package com.yidong.service;

import com.yidong.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> selectBigType();

    List<Type> selectSmallType(int typeId);
}
