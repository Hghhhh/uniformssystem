package com.yidong.controller;

import com.yidong.model.Goods;
import com.yidong.service.GoodsService;
import com.yidong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;


    @RequestMapping("/goods")
    public List getGoods(@RequestParam  String openId){
        String vipGoodId = userService.isVip(openId);
        if(vipGoodId!=null){
            return setMaxAndMinPriceForGoods(goodsService.selectVipGoods(Integer.parseInt(vipGoodId)));
        }
        else{
            return setMaxAndMinPriceForGoods(goodsService.selectGoods());
        }
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
        }
        return list;
    }

    @RequestMapping(value = "/goods/singleGoods")
    public Goods getSingleGoods(int goodsId,@RequestParam String openId){
        String vipGoodId = userService.isVip(openId);
        if(vipGoodId!=null){
            Goods goods  = goodsService.selectSingleVipGoods(Integer.parseInt(vipGoodId));
            goods.setMaxAndMinPrice();
            return goods;
        }
        else{
            Goods goods = goodsService.selectSingleGoods(goodsId);
            goods.setMaxAndMinPrice();
            return goods;
        }
    }

    @RequestMapping(value = "/goods/typeGoods")
    public List<Goods> selecrGoodsByTypeId(@RequestParam  int typeId) {
        return goodsService.selecrGoodsByTypeId(typeId);
    }

}
