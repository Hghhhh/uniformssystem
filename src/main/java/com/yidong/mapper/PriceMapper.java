package com.yidong.mapper;

import com.yidong.model.Price;

public interface PriceMapper {

    Price selectPrice(int id);

    int selectPricePrice(int priceId);

    Price selectPriceForVip(int id);
}
