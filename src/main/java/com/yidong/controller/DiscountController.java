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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public List<Gift> selectGift(@RequestParam String openId){
        if(userMapper.isVip(openId)!=null){
            return null;
        }
        List<Gift>  gifts = discountService.selectGift();
        Collections.sort(gifts,new Comparator<Gift>(){
            @Override
            public int compare(Gift o1, Gift o2) {
                return o1.getFullCondition()>o2.getFullCondition()?1:-1;
            }
        });
        return gifts;
    }

    @RequestMapping("/getTransportFee")
    public TransportFee selectTransportFree(){
        return discountService.selectTransportFree();
    }
}

