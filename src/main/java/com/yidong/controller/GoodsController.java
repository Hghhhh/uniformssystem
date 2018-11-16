package com.yidong.controller;

import com.yidong.model.Goods;
import com.yidong.model.GoodsHot;
import com.yidong.model.Price;
import com.yidong.service.GoodsService;
import com.yidong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;


    @RequestMapping("/goods")
    public List getGoods(){
        return setMaxAndMinPriceForGoods(goodsService.selectGoods());
    }

    /**
     * 为商品列表设置最大价格和最小价格
     * @param list
     * @return list
     */
    public List setMaxAndMinPriceForGoods(List list){
        for(Object goods : list){
            Goods g = (Goods) goods;
            g.setMaxAndMinPrice();
            g.setMaxAndMinTradePrice();
        }
        return list;
    }



    @RequestMapping(value = "/goods/singleGoods")
    public Goods getSingleGoods(@RequestParam  int goodsId,@RequestParam String openId){
        String vipGoodId = userService.isVip(openId);
        if(vipGoodId!=null){
            Goods goods  = goodsService.selectSingleVipGoods(goodsId);
            goods.setMaxAndMinPrice();
            goods.setMaxAndMinTradePrice();
            return goods;
        }
        else{
            Goods goods = goodsService.selectSingleGoods(goodsId);
            goods.setMaxAndMinPrice();
            for(Price p :goods.getPriceList()){
                p.setTradePrice(0);
            }
            return goods;
        }
    }

    @RequestMapping(value = "/goods/typeGoods")
    public List<Goods> selecrGoodsByTypeId(@RequestParam  int typeId) {
        return setMaxAndMinPriceForGoods(goodsService.selecrGoodsByTypeId(typeId));
    }

    @RequestMapping(value = "/goods/nameGoods")
    public List<Goods> selectGoodsByName(@RequestParam  String name) {
        return setMaxAndMinPriceForGoods(goodsService.selectGoodsByName(name));
    }

    @RequestMapping(value = "/goods/recommendGoods")
    public List<Goods> selectRecommendGoods(Integer num) {
        if(num==null){
            num=0;
        }
        return setMaxAndMinPriceForGoods(goodsService.selectRecommendGoods(num));
    }

    @RequestMapping(value = "/goods/hotGoods")
    public List<Goods> selectHotGoods() {
        List<GoodsHot> goodsHots = goodsService.selectHotGoods();
        //对商品list按销量排序
        Collections.sort(goodsHots, new Comparator<GoodsHot>() {
            @Override
            public int compare(GoodsHot o1, GoodsHot o2) {
                return o2.getSaleNum()-o1.getSaleNum();
            }
        });
        List<Goods> goodsList = new ArrayList<Goods>();
        int size = 3;
        if(goodsHots.size()<3){
            size = goodsHots.size();
        }
        for(int i=0;i<size;i++){
            Goods goods = goodsService.selectSingleGoods(goodsHots.get(i).getGoodsId());
            goodsList.add(goods);
        }
        //如果没有商品销售，那么返回3个推荐商品
        if(goodsHots.size()==0){
            goodsList = goodsService.selectRecommendGoods(3);
        }
        return setMaxAndMinPriceForGoods(goodsList);
    }

}
