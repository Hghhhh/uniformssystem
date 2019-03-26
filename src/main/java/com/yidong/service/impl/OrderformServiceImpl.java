package com.yidong.service.impl;

import com.yidong.mapper.GoodsMapper;
import com.yidong.mapper.OrderformMapper;
import com.yidong.mapper.PriceMapper;
import com.yidong.mapper.ShoppingcarMapper;
import com.yidong.model.*;
import com.yidong.service.OrderformService;
import com.yidong.util.DayUtil;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private GoodsMapper goodsMapper;

    public void reduceGoodsNum(int priceId, int buyNum) {
        if (priceMapper.selectNum(priceId) < buyNum) {
            throw new RuntimeException("库存不足");
        } else {
            priceMapper.reduceNum(buyNum, priceId);
        }

    }

    public boolean isPriceOk(OrderformGoods orderformGoods,int isVip){
        Map map = new HashMap(2);
        map.put("priceId",orderformGoods.getPriceId());
        map.put("goodsId",orderformGoods.getGoodsId());
        PriceAndTradePrice priceAndTradePrice = goodsMapper.selectGoodsPrice(map);
        if(priceAndTradePrice==null){
            return false;
        }
        if(isVip==1){
            if(priceAndTradePrice.getTradePrice()!=orderformGoods.getGoodsPrice()){
                return false;
            }
        }
        else{
            if(priceAndTradePrice.getPrice()!=orderformGoods.getGoodsPrice()){
                return false;
            }
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertOrderform(Orderform orderform) {
        int carId = shoppingcarMapper.selectCarId(orderform.getOpenId());
        //减库存,删除购物车商品
        for (OrderformGoods orderformGoods : orderform.getOrderformGoods()) {
            int state = goodsMapper.selectGoodsState(orderformGoods.getGoodsId());
            //判断商品是否已经在后台发生了改变
            if(state==3||state==2
                  ||!isPriceOk(orderformGoods,orderform.getIsVip())){
                return -1;
            }
            reduceGoodsNum(orderformGoods.getPriceId(), orderformGoods.getBuyNum());
            shoppingcarMapper.deleteShoppingcarGoodsByMap(carId, orderformGoods.getPriceId(), orderformGoods.getGoodsId());
        }
        //如果是使用积分支付的话，插入订单积分表，记录使用的积分数
        if (orderform.isIntegralOrder()) {
            Map map = new HashMap();
            map.put("orderformId", orderform.getOrderformId());
            map.put("userId", orderform.getOpenId());
            map.put("integral", orderform.getSumFinal());
            //如果减积分操作没有执行，返回false
            if (orderformMapper.reduceIntegral(map) > 0) {
                orderformMapper.insertOrderformIntegral(map);
                orderform.setState(1);
                orderform.setSumFinal(0);
            } else {
                throw new RuntimeException("减积分操作没有进行");

            }
        } else {
            orderform.setState(0);
        }
       if(insertOrderformGoods(orderform.getOrderformGoods())==false){
            throw new RuntimeException("订单商品插入失败");
       }
        String address = orderform.getAddress();
        String province = null;
        String city = null;
        String district = null;
        if(address.indexOf("省")!=-1&&address.indexOf("市")!=-1){
            province = address.substring(0,address.indexOf("省")+1);
            city = address.substring(address.indexOf("省")+1,address.indexOf("市")+1);
            district = address.substring(address.indexOf("市")+1,address.length());

            if(address.indexOf("区")!=-1){
                district =  district.substring(0,district.indexOf("区")+1);
            }
        }
        else{
            province=address;
            city = address;
            district = address;

        }
        if(orderformMapper.insertOrderform(orderform,province,city,district)<1){
            throw new RuntimeException("订单插入失败");
        }
        return 1;
    }

    @Override
    public boolean insertOrderformGoods(List<OrderformGoods> orderformGoodsList) {
        for (OrderformGoods orderformGoods : orderformGoodsList) {
            orderformGoods.setCode(priceMapper.selectCode(orderformGoods.getPriceId(), orderformGoods.getGoodsId()));
        }
        boolean flag = orderformMapper.insertOrderformGoods(orderformGoodsList) > 0 ? true : false;
        if (flag == false) {
            throw new RuntimeException("添加订单失败");
        }
        else{
            for (OrderformGoods orderformGoods : orderformGoodsList) {
                flag = this.insertOrderformGoodsModel(orderformGoods.getOrderformGoodsId(), orderformGoods.getPriceModels());
            }
            if (flag == false) {
                throw new RuntimeException("添加订单失败");
            }
        }
        return true;
    }


    @Override
    public boolean insertOrderformGoodsModel(int id, List<String> models) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("models", models);
        return orderformMapper.insertOrderformGoodsModel(map) > 0 ? true : false;
    }

    @Override
    public List<Orderform> selectOrderform(String openId) {
        List<Orderform> orderforms = orderformMapper.selectOrderform(openId);
        for (Orderform orderform : orderforms) {
            if(orderform.getGiftId()!=null){
                orderform.setGiftInfo(goodsMapper.selectGiftInfo(orderform.getGiftId()));
            }
        }
        return orderforms;
    }

    @Override
    public Orderform selectOrderformById(String orderformId) {
        System.out.println(orderformId);
        Orderform orderform = orderformMapper.selectOrderformById(orderformId);
        if(orderform==null){
            return null;
        }
        if(orderform.getGiftId()!=null){
            orderform.setGiftInfo(goodsMapper.selectGiftInfo(orderform.getGiftId()));
        }
        return orderform;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOrderform(String orderformId, String remarksWhenRefund, Integer state) {
        Map map = new HashMap();
        map.put("orderformId",orderformId);
        map.put("remarksWhenRefund",remarksWhenRefund);
        map.put("state",state);
        //加入更新时间
        map.put("stateUpdateTime", DayUtil.getDay());
        Orderform orderform = orderformMapper.selectOrderformById(orderformId);
        if(state.equals(orderform.getState())){
            return true;
        }
        if(state==7){
            Retail retail = new Retail();
            retail.setOrderformId(orderform.getOrderformId());
            retail.setSum(orderform.getSumFinal());
            retail.setTime(orderform.getCreateTime());
            retail.setUserId(orderform.getOpenId());
            retail.setSchoolName(orderform.getSchoolName());
            //如果订单完结，且该订单不是vip用户的，才给vip加积分
            if(orderform.getIsVip()==0){
                List<GoodsIdAndBuyNum> goodsIdAndBuyNums = orderformMapper.selectGoodsIdAndBuyNum(orderformId);
                int incIntegral = 0;
                for(GoodsIdAndBuyNum goodsIdAndBuyNum :goodsIdAndBuyNums){
                    incIntegral += goodsIdAndBuyNum.getBuyNum()*goodsIdAndBuyNum.getIntegral();
                }
                Map integralMap = new HashMap();
                integralMap.put("schoolName",orderform.getSchoolName());
                integralMap.put("incIntegral",incIntegral);
                orderformMapper.updateIntegral(integralMap);
                //订单完结，订单不是vip的，则添加零售表
                retail.setGoodsId(orderform.getOrderformGoods().get(0).getGoodsId());
                retail.setNum(orderform.getOrderformGoods().get(0).getBuyNum());
                orderformMapper.insertRetail(retail);
            }
            else{
                //订单完结，订单是vip的，则添加批发表
                retail.setGoodsId(orderform.getOrderformGoods().get(0).getGoodsId());
                retail.setNum(orderform.getOrderformGoods().get(0).getBuyNum());
                orderformMapper.insertWholesale(retail);
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
            //退还库存
            for(OrderformGoods orderformGoods: orderform.getOrderformGoods()) {
                priceMapper.returnNum(orderformGoods.getBuyNum(),orderformGoods.getPriceId());
            }
        }
        else if(state==8){
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


    @Override
    public List<String> getOrderFormId() {
        return orderformMapper.getOrderFormId();
    }

    /**
     * 查询待收货超过七天的订单
     * @return
     */
    @Override
    public List<String> selectWatingOrderForm() {
        return orderformMapper.selectWatingOrderForm();
    }
}
