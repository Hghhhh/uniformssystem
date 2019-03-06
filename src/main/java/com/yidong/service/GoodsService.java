package com.yidong.service;

import com.yidong.model.Goods;
import com.yidong.model.GoodsHot;
import com.yidong.model.VipGoods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> selectGoods();
    List<VipGoods> selectVipGoods();
    VipGoods selectSingleVipGoods(int goodsId);
    Goods selectSingleGoods(int goodsId);
    List<Goods> selectGoodsBySmallTypeId(int smallTypeId);

    List<Goods>  selectGoodsByName(String name);
    List<Goods> selectRecommendGoods(int num);

    List<GoodsHot> selectHotGoods();

    List<Goods> selectGoodsByBigTypeId(int bigTypeId);

    int selectGoodsState(int id);
}
