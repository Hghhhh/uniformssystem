package com.yidong.mapper;

import com.yidong.model.GoodsIdAndBuyNum;
import com.yidong.model.Orderform;
import com.yidong.model.OrderformGoods;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;
public interface OrderformMapper {
    int insertOrderform(Orderform orderform);

    int insertOrderformGoods(List<OrderformGoods> orderformGoodsList);

    int insertOrderformGoodsModel(Map map);

    List<Orderform> selectOrderform(String openId);

    Orderform selectOrderformById(String orderformId);

    int updateOrderform(Map map);

    List<GoodsIdAndBuyNum> selectGoodsIdAndBuyNum(String orderformId);

    int updateIntegral(List<GoodsIdAndBuyNum> goodsIdAndBuyNums);
}