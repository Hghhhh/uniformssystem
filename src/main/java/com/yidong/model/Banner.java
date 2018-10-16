package com.yidong.model;

public class Banner {
    private String imgaddress;

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress == null ? null : imgaddress.trim();
    }
}