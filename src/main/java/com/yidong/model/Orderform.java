package com.yidong.model;

import java.util.Date;

public class Orderform {
    private String id;

    private Integer sumfirst;

    private Integer sumfinal;

    private Integer transportfee;

    private String userid;

    private String name;

    private String address;

    private String phone;

    private String remarkswhenorder;

    private String remarkswhenrefund;

    private String remarksservicereturn;

    private Integer delivery;

    private String expressnumber;

    private String expresscompany;

    private Integer gitfid;

    private Integer giftnum;

    private Integer state;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSumfirst() {
        return sumfirst;
    }

    public void setSumfirst(Integer sumfirst) {
        this.sumfirst = sumfirst;
    }

    public Integer getSumfinal() {
        return sumfinal;
    }

    public void setSumfinal(Integer sumfinal) {
        this.sumfinal = sumfinal;
    }

    public Integer getTransportfee() {
        return transportfee;
    }

    public void setTransportfee(Integer transportfee) {
        this.transportfee = transportfee;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemarkswhenorder() {
        return remarkswhenorder;
    }

    public void setRemarkswhenorder(String remarkswhenorder) {
        this.remarkswhenorder = remarkswhenorder == null ? null : remarkswhenorder.trim();
    }

    public String getRemarkswhenrefund() {
        return remarkswhenrefund;
    }

    public void setRemarkswhenrefund(String remarkswhenrefund) {
        this.remarkswhenrefund = remarkswhenrefund == null ? null : remarkswhenrefund.trim();
    }

    public String getRemarksservicereturn() {
        return remarksservicereturn;
    }

    public void setRemarksservicereturn(String remarksservicereturn) {
        this.remarksservicereturn = remarksservicereturn == null ? null : remarksservicereturn.trim();
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public String getExpressnumber() {
        return expressnumber;
    }

    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber == null ? null : expressnumber.trim();
    }

    public String getExpresscompany() {
        return expresscompany;
    }

    public void setExpresscompany(String expresscompany) {
        this.expresscompany = expresscompany == null ? null : expresscompany.trim();
    }

    public Integer getGitfid() {
        return gitfid;
    }

    public void setGitfid(Integer gitfid) {
        this.gitfid = gitfid;
    }

    public Integer getGiftnum() {
        return giftnum;
    }

    public void setGiftnum(Integer giftnum) {
        this.giftnum = giftnum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}