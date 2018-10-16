package com.yidong.mapper;

import com.yidong.model.Orderform;

public interface OrderformMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);
}