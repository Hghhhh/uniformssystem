package com.yidong.model;


public class VipGoods extends Goods{

    /**
     * 卖出一件该商品可获得的积分
     */
    private float integral;

    /**
     * 起批量
     */
    private Integer batch;

    /**
     * 总零售量
     */
    private int allRetail;

    /**
     *
     * 本月零售量
     */
    private int monthRetail;


    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public float getIntegral() {
        return integral;
    }

    public void setIntegral(float integral) {
        this.integral = integral;
    }

    public int getAllRetail() {
        return allRetail;
    }

    public void setAllRetail(String allRetail) {
        if(allRetail==null){
            allRetail="0";
        }
        if(allRetail.equals("null")){
            allRetail="0";
        }
        this.allRetail = Integer.parseInt(allRetail);
    }

    public int getMonthRetail() {
        return monthRetail;
    }

    public void setMonthRetail(String monthRetail) {
        if(monthRetail==null){
            monthRetail="0";
        }
        if(monthRetail.equals("null")){
            monthRetail="0";
        }
        this.monthRetail = Integer.parseInt(monthRetail);
    }
}