package com.yidong.service.impl;

import com.yidong.mapper.GoodsMapper;
import com.yidong.model.Goods;
import com.yidong.model.GoodsHot;
import com.yidong.model.VipGoods;
import com.yidong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<VipGoods> selectVipGoods() {
        return goodsMapper.selectVipGoods();
    }

    @Override
    public VipGoods selectSingleVipGoods(int goodsId) {
        return goodsMapper.selectSingleVipGoods(goodsId);
    }

    @Override
    public Goods selectSingleGoods(int goodsId) {
        return goodsMapper.selectSingleGoods(goodsId);
    }

    @Override
    public List<Goods> selecrGoodsByTypeId(int smallTypeId) {
        return goodsMapper.selecrGoodsByTypeId(smallTypeId);
    }

    @Override
    public List<Goods> selectGoodsByName(String name) {
        return goodsMapper.selectGoodsByName(name);
    }

    @Override
    public List<Goods> selectRecommendGoods(int num) {
        return goodsMapper.selectRecommendGoods(num);
    }

    @Override
    public List<GoodsHot> selectHotGoods() {
        List<GoodsHot> retailGoodsHots = goodsMapper.selectRetailHot();
        List<GoodsHot> wholeGoodsHots = goodsMapper.selectWholeHot();
        List<GoodsHot> goodsHots = new ArrayList<GoodsHot>();
        List<GoodsHot> retailGoodsHotsTem = new ArrayList<GoodsHot>();
        List<GoodsHot> wholeGoodsHotsTem = new ArrayList<GoodsHot>();
        retailGoodsHotsTem.addAll(retailGoodsHots);
        wholeGoodsHotsTem.addAll(wholeGoodsHots);
        for(GoodsHot rgoodsHot: retailGoodsHots){
            for(GoodsHot wgoodsHot : wholeGoodsHots){
                if(rgoodsHot.getGoodsId()==wgoodsHot.getGoodsId()){
                    rgoodsHot.setSaleNum(rgoodsHot.getSaleNum()+wgoodsHot.getSaleNum());
                    goodsHots.add(rgoodsHot);
                    retailGoodsHotsTem.remove(rgoodsHot);
                    wholeGoodsHotsTem.remove(wgoodsHot);
                    continue;
                }
            }
        }
        goodsHots.addAll(retailGoodsHotsTem);
        goodsHots.addAll(wholeGoodsHotsTem);
        return goodsHots;
    }
}
