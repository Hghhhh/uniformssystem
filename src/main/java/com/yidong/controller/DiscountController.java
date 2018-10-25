package com.yidong.controller;

import com.yidong.mapper.UserMapper;
import com.yidong.model.Discount;
import com.yidong.model.Gift;
import com.yidong.model.TransportFee;
import com.yidong.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController  {

    @Autowired
    private DiscountService discountService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getDiscount")
    public Discount selectDiscount(@RequestParam String openId){
        if(userMapper.isVip(openId)!=null){
            return null;
        }
        return discountService.selectDiscount();
    }

    @RequestMapping("/getGift")
    public Gift selectGift(@RequestParam String openId){
        if(userMapper.isVip(openId)!=null){
            return null;
        }
        return discountService.selectGift();
    }


    @RequestMapping("/getTransportFree")
    public TransportFee selectTransportFree(){
        return discountService.selectTransportFree();
    }
}

