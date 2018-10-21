package com.yidong.service.impl;

import com.yidong.mapper.GoodsMapper;
import com.yidong.model.Goods;
import com.yidong.model.VipGoods;
import com.yidong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoods() {
        return goodsMapper.selectGoods();
    }

    @Override
    public List<VipGoods> selectVipGoods(int goodsId) {
        return goodsMapper.selectVipGoods(goodsId);
    }

    @Override
    public Goods selectSingleGoods(int goodsId) {
        return goodsMapper.selectSingleGoods(goodsId);
    }
}
