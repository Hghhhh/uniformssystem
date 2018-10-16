package com.yidong.model;

import java.util.Date;

public class Discount {
    private Integer discountcondition;

    private Integer reduce;

    private Float discount;

    private Date start;

    private Date end;

    public Integer getDiscountcondition() {
        return discountcondition;
    }

    public void setDiscountcondition(Integer discountcondition) {
        this.discountcondition = discountcondition;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}