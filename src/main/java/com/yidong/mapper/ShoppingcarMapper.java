package com.yidong.mapper;

import java.util.Map;

import com.yidong.model.ShoppingCarIdAndBuyNum;
import com.yidong.model.Shoppingcar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingcarMapper {
    List<Shoppingcar> selectShoppingcar(String openId);

    List<Shoppingcar> selectVipShoppingcar(String openId);

    int selectPriceNumByShoppingcarGoodsId(int id);

    int updateShoppingcarBuyNum(Map map);

    int updateShoppingcarState(Map map);

    int deleteShoppingcarGoods(int id);

    int insertShoppingcarGoods(Map map);

    int selectCarId(String openId);

    ShoppingCarIdAndBuyNum selectShoppingcarBuyNumWhenInsert(Map map);

    Shoppingcar selectShoppingcarGoodsById(int id);

    int deleteShoppingcarGoodsByMap(@Param("carId") int carId,@Param("priceId") int priceId,@Param("goodsId") int goodsId);
}