package com.yidong.service.impl;

import com.yidong.mapper.OrderformMapper;
import com.yidong.mapper.PriceMapper;
import com.yidong.mapper.ShoppingcarMapper;
import com.yidong.model.GoodsIdAndBuyNum;
import com.yidong.model.Orderform;
import com.yidong.model.OrderformGoods;
import com.yidong.model.Retail;
import com.yidong.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Service
public class OrderformServiceImpl implements OrderformService {
    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private ShoppingcarMapper shoppingcarMapper;

    public void reduceGoodsNum(int priceId,int buyNum){
        if(priceMapper.selectNum(priceId)<buyNum){
            throw new RuntimeException("库存不足");
        }
        else{
            priceMapper.reduceNum(buyNum,priceId);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertOrderform(Orderform orderform) {
        int carId = shoppingcarMapper.selectCarId(orderform.getOpenId());
        //减库存,删除购物车商品
        for(OrderformGoods orderformGoods: orderform.getOrderformGoods()) {
            reduceGoodsNum(orderformGoods.getPriceId(),orderformGoods.getBuyNum());
            shoppingcarMapper.deleteShoppingcarGoodsByMap(carId,orderformGoods.getPriceId(),orderformGoods.getGoodsId());
        }
       //如果是使用积分支付的话，插入订单积分表，记录使用的积分数
        if(orderform.isIntegralOrder()){
            Map map = new HashMap();
            map.put("orderformId",orderform.getOrderformId());
            map.put("userId",orderform.getOpenId());
            map.put("integral",orderform.getSumFinal());
            //如果减积分操作没有执行，返回false
            if(orderformMapper.reduceIntegral(map)>0){
                orderformMapper.insertOrderformIntegral(map);
                orderform.setState(1);
            }
            else{
                return false;
            }
        }
        else{
            orderform.setState(0);
        }
        boolean flag = insertOrderformGoods(orderform.getOrderformGoods());
        boolean flag2 = orderformMapper.insertOrderform(orderform)>0?true:false;
        return flag&&flag2;
    }

    @Override
    public boolean insertOrderformGoods(List<OrderformGoods> orderformGoodsList) {
        boolean flag = orderformMapper.insertOrderformGoods(orderformGoodsList)>0?true:false;
        if(flag) {
            for (OrderformGoods orderformGoods : orderformGoodsList) {
                flag=this.insertOrderformGoodsModel(orderformGoods.getOrderformGoodsId(), orderformGoods.getPriceModels());
            }
        }
        else{
            throw new RuntimeException("添加订单失败");
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOrderform(String orderformId, String remarksWhenRefund, Integer state) {
        Map map = new HashMap();
        map.put("orderformId",orderformId);
        map.put("remarksWhenRefund",remarksWhenRefund);
        map.put("state",state);
        if(state==7){
            String vipUserId = orderformMapper.selectVipUserByOrderformId(orderformId);
            Orderform orderform = orderformMapper.selectOrderformById(orderformId);
            Retail retail = new Retail();
            retail.setOrderformId(orderform.getOrderformId());
            retail.setSum(orderform.getSumFinal());
            retail.setTime(orderform.getCreateTime());
            retail.setUserId(orderform.getOpenId());
            //如果订单完结，且该订单不是vip用户的，才给vip加积分
            if(null==vipUserId||
                    "".equals(vipUserId)){
                List<GoodsIdAndBuyNum> goodsIdAndBuyNums = orderformMapper.selectGoodsIdAndBuyNum(orderformId);
                orderformMapper.updateIntegral(goodsIdAndBuyNums);
                //订单完结，订单不是vip的，则添加零售表
                for(OrderformGoods orderformGoods : orderform.getOrderformGoods()){
                    retail.setGoodsId(orderformGoods.getGoodsId());
                    retail.setNum(orderformGoods.getBuyNum());
                    orderformMapper.insertRetail(retail);
                }
            }
            else{
                //订单完结，订单是vip的，则添加批发表
                for(OrderformGoods orderformGoods : orderform.getOrderformGoods()){
                    retail.setGoodsId(orderformGoods.getGoodsId());
                    retail.setNum(orderformGoods.getBuyNum());
                    orderformMapper.insertWholesale(retail);
                }
            }
        }
        //如果退款，判断是不是积分付款的，是的话退还积分
        else if(state==4){
            //获取订单积分表中的信息，如果不为空说明是积分支付的
            Map m = orderformMapper.selectUserIdAndIntegralByOrderformId(orderformId);

            if(null!=m ){
                if(!m.isEmpty()){
                    orderformMapper.updateVipIntegral(m);
                }
            }
            Orderform orderform = selectOrderformById(orderformId);
            //退还库存
            for(OrderformGoods orderformGoods: orderform.getOrderformGoods()) {
                priceMapper.returnNum(orderformGoods.getBuyNum(),orderformGoods.getPriceId());
            }
        }
        return orderformMapper.updateOrderform(map)>0?true:false;
    }

    @Override
    public String selectOrderformIdIsExistInIntegral(String orderformId) {
        return  orderformMapper.selectOrderformIdIsExistInIntegral(orderformId);
    }

}
