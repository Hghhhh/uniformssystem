package com.yidong.model;

import java.util.List;

public class OrderformGoods extends GoodsInfo {
    public int getOrderformGoodsId() {
        return orderformGoodsId;
    }

    public void setOrderformGoodsId(int orderformGoodsId) {
        this.orderformGoodsId = orderformGoodsId;
    }

    private int orderformGoodsId;
    private String orderformId;
    private int priceId;
    private int goodsPrice;
    private List<String> priceModels;
    private int buyNum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

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

}
