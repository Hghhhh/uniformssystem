package com.yidong.model;

/**
 * @author hgh
 */
public class User {

    private String openId;

    private String phone;

    private Float integral;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Float getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = Float.valueOf(integral);
    }
}
