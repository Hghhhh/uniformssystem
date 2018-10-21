package com.yidong.service.impl;

import com.yidong.mapper.ShoppingcarMapper;
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

    @Override
    public List<Shoppingcar> selectShoppingcar(String openId) {
        return shoppingcarMapper.selectShoppingcar(openId);
    }

    @Override
    public boolean updateShoppingcarBuyNum(int buyNum, int id) {
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


}
