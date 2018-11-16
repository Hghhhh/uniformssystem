package com.yidong.model;

import java.util.List;

public class Shoppingcar {
    private int shoppingcarId;
    private GoodsInfo shoppingcarGoods;
    private int priceId;
    private int price;
    private List<String> priceModels;
    private int buyNum;
    private int state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getShoppingcarId() {
        return shoppingcarId;
    }

    public void setShoppingcarId(int shoppingcarId) {
        this.shoppingcarId = shoppingcarId;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public GoodsInfo getShoppingcarGoods() {
        return shoppingcarGoods;
    }

    public void setShoppingcarGoods(GoodsInfo shoppingcarGoods) {
        this.shoppingcarGoods = shoppingcarGoods;
    }

}