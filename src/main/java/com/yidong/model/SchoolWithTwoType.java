package com.yidong.model;

import java.io.Serializable;
import java.util.List;

public class SchoolWithTwoType {


    private String smType;

    private List<String> children;


    public String getSmType() {
        return smType;
    }

    public void setSmType(String smType) {
        this.smType = smType;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
