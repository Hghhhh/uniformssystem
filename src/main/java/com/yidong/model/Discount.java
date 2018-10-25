package com.yidong.model;

import java.util.Date;

public class Discount {
    private Integer discountCondition;

    private Integer reduce;

    private Float discount;

    private String start;

    private String end;


    public Integer getDiscountCondition() {
        return discountCondition;
    }

    public void setDiscountCondition(Integer discountCondition) {
        this.discountCondition = discountCondition;
    }

    public Integer getReduce() {
        return reduce;
    }

    public void setReduce(Integer reduce) {
        this.reduce = reduce;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start.substring(0,start.length()-2);
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end.substring(0,end.length()-2);
    }
}