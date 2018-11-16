package com.yidong.service.impl;

import com.yidong.mapper.ShoppingcarMapper;
import com.yidong.mapper.UserMapper;
import com.yidong.model.Shoppingcar;
import com.yidong.service.ShoppingcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Service
public class ShoppingcarServiceImpl implements ShoppingcarService {
    @Autowired
    private ShoppingcarMapper shoppingcarMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Shoppingcar> selectShoppingcar(String openId) {

        String integral=userMapper.selectIntegral(openId);
        if(integral==null || "".equals(integral)){
            integral="-1";
        }
        boolean isVip = Float.valueOf(integral)==-1?false:true;
        if(isVip){
            return shoppingcarMapper.selectVipShoppingcar(openId);
        }
        else{
            List<Shoppingcar> shoppingcars = shoppingcarMapper.selectShoppingcar(openId);
            for(Shoppingcar shoppingcar:shoppingcars){
                shoppingcar.getShoppingcarGoods().setBatch(1);
            }
            return shoppingcars;
        }
    }

    @Override
    public boolean updateShoppingcarBuyNum(int buyNum, int id) {
        int priceNum = shoppingcarMapper.selectPriceNumByShoppingcarGoodsId(id);
        if(buyNum>priceNum){
            return false;
        }
        Map map = new HashMap();
        map.put("buyNum",buyNum);
        map.put("id",id);
        return shoppingcarMapper.updateShoppingcarBuyNum(map)==1?true:false;
    }

    @Override
    public boolean updateShoppingcarState(int state,int id) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("state",state);
        return shoppingcarMapper.updateShoppingcarState(map)==1?true:false;
    }

    @Override
    public boolean deleteShoppingcarGoods(int id) {
        return shoppingcarMapper.deleteShoppingcarGoods(id)==1?true:false;
    }

    @Override
    public boolean insertShoppingcarGoods(int carId, int buyNum, int priceId, int goodsId) {
        Map map = new HashMap();
        map.put("carId",carId);
        map.put("buyNum",buyNum);
        map.put("priceId",priceId);
        map.put("goodsId",goodsId);
        int count = shoppingcarMapper.updateShoppingcarBuyNumWhenInsert(map);
        //如果购物车已有该商品，合并buyNum，否则再添加商品
        if(count>0){
            return true;
        }
        else{
            return shoppingcarMapper.insertShoppingcarGoods(map)==1?true:false;
        }
    }

    @Override
    public int selectCarId(String openId) {
        return shoppingcarMapper.selectCarId(openId);
    }

    @Override
    public Shoppingcar selectShoppingcarGoodsById(int id) {
        return shoppingcarMapper.selectShoppingcarGoodsById(id);
    }


}
