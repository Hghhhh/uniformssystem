package com.yidong.mapper;

import com.yidong.model.Goods;
import com.yidong.model.GoodsHot;
import com.yidong.model.GoodsInfo;
import com.yidong.model.VipGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectGoods();

    List<VipGoods> selectVipGoods();

    VipGoods selectSingleVipGoods(int goodsId);

    GoodsInfo selectGoodsInfo(int goodsId);

    Goods selectSingleGoods(int goodsId);

    String selectGoodsName(int goodsId);

    List<Goods> selecrGoodsByTypeId(int smallTypeId);

    List<Goods>  selectGoodsByName(@Param(value="name") String name);

    List<Goods> selectRecommendGoods(@Param(value="num")int num);

    List<GoodsHot> selectRetailHot();

    List<GoodsHot> selectWholeHot();
}