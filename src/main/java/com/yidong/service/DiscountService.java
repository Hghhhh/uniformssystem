package com.yidong.service;

import com.yidong.model.Discount;
import com.yidong.model.Gift;
import com.yidong.model.TransportFee;


public interface DiscountService {
    Discount selectDiscount();

    Gift selectGift();

    TransportFee selectTransportFree();
}
