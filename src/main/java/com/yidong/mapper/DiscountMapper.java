package com.yidong.mapper;

import com.yidong.model.Discount;

public interface DiscountMapper {
    int insert(Discount record);

    int insertSelective(Discount record);
}