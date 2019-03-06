package com.yidong.model;

import java.io.Serializable;
import java.util.List;

/**
 * 学校名的一个三级联动
 */
public class SchoolWithThreeType {

    private String bigType;

    private List<SchoolWithTwoType> children;

    public String getBigType() {
        return bigType;
    }

    public void setBigType(String bigType) {
        this.bigType = bigType;
    }

    public List<SchoolWithTwoType> getChildren() {
        return children;
    }

    public void setChildren(List<SchoolWithTwoType> children) {
        this.children = children;
    }


}
