package com.yidong.mapper;

import com.yidong.model.Shoppingcar;

public interface ShoppingcarMapper {
    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);
}