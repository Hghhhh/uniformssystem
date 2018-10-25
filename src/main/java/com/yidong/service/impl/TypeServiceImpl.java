package com.yidong.service.impl;

import com.yidong.mapper.TypeMapper;
import com.yidong.model.Type;
import com.yidong.service.TypeService;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> selectBigType() {
        return typeMapper.selectBigType();
    }

    @Override
    public List<Type> selectSmallType(int typeId) {
        return typeMapper.selectSmallType(typeId);
    }
}
