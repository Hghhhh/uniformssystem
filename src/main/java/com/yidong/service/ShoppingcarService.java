package com.yidong.service;

import com.yidong.model.Shoppingcar;

import java.util.List;

public interface ShoppingcarService {
    List<Shoppingcar> selectShoppingcar(String openId);

    boolean updateShoppingcarBuyNum(int buyNum,int id);

    boolean updateShoppingcarState(int state,int id);

    boolean deleteShoppingcarGoods(int id);
}
