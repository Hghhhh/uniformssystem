package com.yidong.mapper;

import java.util.Map;
import com.yidong.model.Shoppingcar;

import java.util.List;

public interface ShoppingcarMapper {
    List<Shoppingcar> selectShoppingcar(String openId);

    int updateShoppingcarBuyNum(Map map);

    int updateShoppingcarState(Map map);

    int deleteShoppingcarGoods(int id);

    int insertShoppingcarGoods(Map map);

    int selectCarId(String openId);

    int updateShoppingcarBuyNumWhenInsert(Map map);
}