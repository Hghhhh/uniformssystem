package com.yidong.model;

/**
 * 零售表和批发表所对应的java对象
 * @author Administrator
 */
public class Retail {
    private int goodsId;
    private String orderformId;
    private int num;
    private String time;
    private String userId;
    private int sum;
    private String schoolName;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(String orderformId) {
        this.orderformId = orderformId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
