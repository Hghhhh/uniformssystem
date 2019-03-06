package com.yidong.model;

import java.util.List;

public class Orderform {
    private String orderformId;

    private boolean integralOrder;

    private String openId;

    private String name;

    private String address;

    private String phone;

    private List<OrderformGoods> orderformGoods;

    private Integer giftId;

    private Integer giftNum;

    private Integer transportFee;

    private Integer sumFirst;

    private Integer sumFinal;

    private Integer state;

    private String createTime;

    private String remarksWhenOrder;

    private String remarksWhenRefund;

    private String remarksServiceReturn;

    private String schoolName;

    private int isVip;

    private GiftInfo giftInfo;

    private Express express;


    public void setOrderformIdForOrderformGoods(){
        for(OrderformGoods og : this.orderformGoods){
            og.setOrderformId(this.orderformId);
        }
    }

    public String getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(String orderformId) {
        this.orderformId = orderformId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderformGoods> getOrderformGoods() {
        return orderformGoods;
    }

    public void setOrderformGoods(List<OrderformGoods> orderformGoods) {
        this.orderformGoods = orderformGoods;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    public Integer getSumFirst() {
        return sumFirst;
    }

    public void setSumFirst(Integer sumFirst) {
        this.sumFirst = sumFirst;
    }

    public Integer getSumFinal() {
        return sumFinal;
    }

    public void setSumFinal(Integer sumFinal) {
        this.sumFinal = sumFinal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime.substring(0,createTime.length()-2);
    }

    public String getRemarksServiceReturn() {
        return remarksServiceReturn;
    }

    public void setRemarksServiceReturn(String remarksServiceReturn) {
        this.remarksServiceReturn = remarksServiceReturn;
    }

    public Integer getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(Integer transportFee) {
        this.transportFee = transportFee;
    }

    public String getRemarksWhenOrder() {
        return remarksWhenOrder;
    }

    public void setRemarksWhenOrder(String remarksWhenOrder) {
        this.remarksWhenOrder = remarksWhenOrder;
    }

    public String getRemarksWhenRefund() {
        return remarksWhenRefund;
    }

    public void setRemarksWhenRefund(String remarksWhenRefund) {
        this.remarksWhenRefund = remarksWhenRefund;
    }

    public boolean isIntegralOrder() {
        return integralOrder;
    }

    public void setIntegralOrder(String orderformId) {
        if(null==orderformId||"".equals(orderformId)){
            this.integralOrder = false;
        }
        else{
            this.integralOrder = true;
        }

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public GiftInfo getGiftInfo() {
        return giftInfo;
    }

    public void setGiftInfo(GiftInfo giftInfo) {
        this.giftInfo = giftInfo;
        if(giftInfo!=null){
            this.giftInfo.setNum(giftNum);
        }
    }

    public int getIsVip() {
        return isVip;
    }

    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(Express express) {
        this.express = express;
    }
}