package com.yidong.model;

import java.util.List;

/**
 * @author hgh
 */
public class Goods {
    private int maxPrice;

    private int minPrice;

    private Integer goodsId;

    private String goodsName;

    private String detail;

    private List<String> goodsPicture;

    private List<Price> priceList;


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

    public List<String> getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(List<String> goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}