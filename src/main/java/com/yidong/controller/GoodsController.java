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

@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    public List getGoods(@RequestParam  String openId){
        String vipGoodId = userService.isVip(openId);
        if(vipGoodId!=null){
            return goodsService.selectVipGoods(Integer.parseInt(vipGoodId));
        }
        else{
            return goodsService.selectGoods();
        }
    }

    @RequestMapping(value = "singleGoods")
    public Goods getSingleGoods(@RequestParam int goodsId){
       return goodsService.selectSingleGoods(goodsId);
    }


}
