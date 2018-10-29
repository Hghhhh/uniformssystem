package com.yidong.service;

import com.yidong.model.Goods;
import com.yidong.model.VipGoods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectGoods();
    List<VipGoods> selectVipGoods(int goodsId);
    VipGoods selectSingleVipGoods(int goodsId);
    Goods selectSingleGoods(int goodsId);
    List<Goods> selecrGoodsByTypeId(int smallTypeId);

    List<Goods>  selectGoodsByName(String name);
}
