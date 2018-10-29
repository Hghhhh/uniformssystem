package com.yidong.service.impl;

import com.yidong.mapper.DiscountMapper;
import com.yidong.model.Discount;
import com.yidong.model.Gift;

import com.yidong.model.TransportFee;
import com.yidong.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountMapper discountMapper;

    @Override
    public Discount selectDiscount() {
        return discountMapper.selectDiscount();
    }

    @Override
    public List<Gift> selectGift() {
        return discountMapper.selectGift();
    }

    @Override
    public TransportFee selectTransportFree() {
        return discountMapper.selectTransportFree();
    }
}
