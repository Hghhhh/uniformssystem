package com.yidong.service.impl;

import com.sun.javafx.collections.MappingChange;
import com.yidong.mapper.OrderformMapper;
import com.yidong.mapper.PriceMapper;
import com.yidong.model.GoodsIdAndBuyNum;
import com.yidong.model.Orderform;
import com.yidong.model.OrderformGoods;
import com.yidong.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Service
public class OrderformServiceImpl implements OrderformService {
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private PriceMapper priceMapper;

    @Override
    public boolean insertOrderform(Orderform orderform) {
        for(OrderformGoods orderformGoods: orderform.getOrderformGoods()) {
            priceMapper.reduceNum(orderformGoods.getBuyNum(),orderformGoods.getPriceId());
        }
        return orderformMapper.insertOrderform(orderform)>0?true:false && insertOrderformGoods(orderform.getOrderformGoods());
    }

    @Override
    public boolean insertOrderformGoods(List<OrderformGoods> orderformGoodsList) {
        boolean flag = orderformMapper.insertOrderformGoods(orderformGoodsList)>0?true:false;
        if(flag) {
            for (OrderformGoods orderformGoods : orderformGoodsList) {
                flag=this.insertOrderformGoodsModel(orderformGoods.getId(), orderformGoods.getPriceModels());
                if(!flag){
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean insertOrderformGoodsModel(int id, List<String> models) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("models",models);
        return orderformMapper.insertOrderformGoodsModel(map)>0?true:false;
    }

    @Override
    public List<Orderform> selectOrderform(String openId) {
        return orderformMapper.selectOrderform(openId);
    }

    @Override
    public Orderform selectOrderformById(String orderformId) {
        return orderformMapper.selectOrderformById(orderformId);
    }

    @Override
    public boolean updateOrderform(String orderformId, String remarksWhenRefund, Integer state) {
        Map map = new HashMap();
        map.put("orderformId",orderformId);
        map.put("remarksWhenRefund",remarksWhenRefund);
        map.put("state",state);
        //如果订单完结，给vip加积分
        if(state==7){
            List<GoodsIdAndBuyNum> goodsIdAndBuyNums = orderformMapper.selectGoodsIdAndBuyNum(orderformId);
            orderformMapper.updateIntegral(goodsIdAndBuyNums);
        }
        return orderformMapper.updateOrderform(map)>0?true:false;
    }
}
