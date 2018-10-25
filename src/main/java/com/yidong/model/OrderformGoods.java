package com.yidong.model;

import java.util.List;

public class OrderformGoods extends GoodsInfo {
    private int id;
    private String orderformId;
    private int priceId;
    private int goodsPrice;
    private List<String> priceModels;
    private int buyNum;

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public List<String> getPriceModels() {
        return priceModels;
    }

    public void setPriceModels(List<String> priceModels) {
        this.priceModels = priceModels;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public String getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(String orderformId) {
        this.orderformId = orderformId;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
