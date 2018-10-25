package com.yidong.service;

import com.yidong.model.GoodsIdAndBuyNum;
import com.yidong.model.Orderform;
import com.yidong.model.OrderformGoods;

import java.util.List;

public interface OrderformService {
    boolean insertOrderform(Orderform orderform);

    boolean insertOrderformGoods(List<OrderformGoods> orderformGoodsList);

    boolean insertOrderformGoodsModel(int id,List<String> models);

    List<Orderform> selectOrderform(String openId);

    Orderform selectOrderformById(String orderformId);

    boolean updateOrderform(String orderformId,String remarksWhenRefund,Integer state);

}
