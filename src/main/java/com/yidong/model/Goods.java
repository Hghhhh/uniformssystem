package com.yidong.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author hgh
 */
public class Goods {
    private int maxPrice;

    private int minPrice;

    private int maxTradePrice;

    private int minTradePrice;

    private Integer goodsId;

    private String goodsName;

    private String detail;

    private int state;

    private List<String> detailList;

    private List<String> goodsPicture;

    private List<Price> priceList;

    public void setDetailList(){
        if(detail==null){
            return ;
        }
        else{
            this.detailList = Arrays.asList(detail.split(","));
        }
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

    public void setMaxAndMinTradePrice(){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int p;
        for(Price price : this.getPriceList()){
            p = price.getTradePrice();
            if(max<p){
                max=p;
            }
            if(min>p){
                min=p;
            }
        }
        this.maxTradePrice=max;
        this.minTradePrice=min;
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

    public int getMaxTradePrice() {
        return maxTradePrice;
    }

    public void setMaxTradePrice(int maxTradePrice) {
        this.maxTradePrice = maxTradePrice;
    }

    public int getMinTradePrice() {
        return minTradePrice;
    }

    public void setMinTradePrice(int minTradePrice) {
        this.minTradePrice = minTradePrice;
    }

    public List<String> getDetailList() {
        return detailList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}