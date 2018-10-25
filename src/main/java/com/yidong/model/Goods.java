package com.yidong.model;

import java.util.List;

/**
 * @author hgh
 */
public class Goods {
    private int maxPrice;

    private int minPrice;

    private Integer goodsId;

    private String name;

    private String detail;

    private List<String> pictures;

    private List<Price> priceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }


    public void setMaxAndMinPrice(){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int p;
        for(Price price : this.getPriceList()){
            p = price.getPrice();
            if(max<p){
                max=p;
            }
            if(min>p){
                min=p;
            }
        }
        this.maxPrice=max;
        this.minPrice=min;
    }
}