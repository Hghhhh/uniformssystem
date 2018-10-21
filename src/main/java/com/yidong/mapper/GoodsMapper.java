package com.yidong.mapper;

import com.yidong.model.Goods;
import com.yidong.model.ShoppingcarGoods;
import com.yidong.model.VipGoods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectGoods();

    List<VipGoods> selectVipGoods(int goodsId);

    ShoppingcarGoods selectShoppingcarGoods(String goodsId);

    Goods selectSingleGoods(int goodsId);
}