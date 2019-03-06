package com.yidong.mapper;

import com.yidong.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    List<Goods> selectGoods();

    List<VipGoods> selectVipGoods();

    VipGoods selectSingleVipGoods(int goodsId);

    GoodsInfo selectGoodsInfo(int goodsId);

    Goods selectSingleGoods(int goodsId);

    String selectGoodsName(int goodsId);

    List<Goods> selectGoodsBySmallTypeId(int smallTypeId);

    List<Goods>  selectGoodsByName(@Param(value="name") String name);

    List<Goods> selectRecommendGoods(@Param(value="num")int num);

    List<GoodsHot> selectRetailHot();

    List<GoodsHot> selectWholeHot();

    GiftInfo selectGiftInfo(int giftId);

    List<Goods> selectGoodsByBigTypeId(int bigTypeId);


    int selectGoodsState(int id);

    PriceAndTradePrice selectGoodsPrice(Map map);

}