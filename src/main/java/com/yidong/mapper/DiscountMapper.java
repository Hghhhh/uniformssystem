package com.yidong.mapper;

import com.yidong.model.Discount;
import com.yidong.model.Gift;
import com.yidong.model.TransportFee;


public interface DiscountMapper {
    Discount selectDiscount();

    Gift selectGift();

    TransportFee selectTransportFree();
}