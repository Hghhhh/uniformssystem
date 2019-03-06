package com.yidong.mapper;

import com.yidong.model.Price;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface PriceMapper {

    Price selectPrice(int id);

    int selectPricePrice(int priceId);

    int  selectTradePrice(int priceId);

    Price selectPriceForVip(int id);

    int reduceNum(@Param("buyNum")int buyNum, @Param("priceId")int priceId);

    int returnNum(@Param("buyNum")int buyNum, @Param("priceId")int priceId);

   // Float selectPriceIntegral(int priceId);

    Integer selectNum(int priceId);

    Price selectPriceForGoodsDetail(int id);

    String selectCode(@Param("priceId")int priceId,@Param("goodsId")int goodsId);
}
