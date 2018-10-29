package com.yidong.service;

import com.yidong.model.Discount;
import com.yidong.model.Gift;
import com.yidong.model.TransportFee;

import java.util.List;


public interface DiscountService {
    Discount selectDiscount();

    List<Gift> selectGift();

    TransportFee selectTransportFree();
}
