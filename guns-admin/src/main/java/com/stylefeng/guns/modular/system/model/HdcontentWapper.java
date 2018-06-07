package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ${description}
 * @author: shengx
 * @create: 2018-05-26 14:30
 */
public class HdcontentWapper implements Serializable {
    private List<Hdcontent> first;
    private List<Hdcontent> second;
    private List<Hdcontent> third;

    public List<Hdcontent> getFirst() {
        return first;
    }

    public void setFirst(List<Hdcontent> first) {
        this.first = first;
    }

    public List<Hdcontent> getSecond() {
        return second;
    }

    public void setSecond(List<Hdcontent> second) {
        this.second = second;
    }

    public List<Hdcontent> getThird() {
        return third;
    }

    public void setThird(List<Hdcontent> third) {
        this.third = third;
    }
}
