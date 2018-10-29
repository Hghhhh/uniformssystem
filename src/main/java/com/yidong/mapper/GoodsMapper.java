package com.yidong.mapper;

import com.yidong.model.Goods;
import com.yidong.model.GoodsInfo;
import com.yidong.model.VipGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> selectGoods();

    List<VipGoods> selectVipGoods(int goodsId);

    VipGoods selectSingleVipGoods(int goodsId);

    GoodsInfo selectGoodsInfo(int goodsId);

    Goods selectSingleGoods(int goodsId);

    String selectGoodsName(int goodsId);

    List<Goods> selecrGoodsByTypeId(int smallTypeId);

    List<Goods>  selectGoodsByName(@Param(value="name") String name);
}