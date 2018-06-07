package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ${description}
 * @author: shengx
 * @create: 2018-05-26 14:30
 */
public class CdcontentWapper implements Serializable {
    private List<Cdcontent> first;
    private List<Cdcontent> second;
    private List<Cdcontent> third;

    public List<Cdcontent> getFirst() {
        return first;
    }

    public void setFirst(List<Cdcontent> first) {
        this.first = first;
    }

    public List<Cdcontent> getSecond() {
        return second;
    }

    public void setSecond(List<Cdcontent> second) {
        this.second = second;
    }

    public List<Cdcontent> getThird() {
        return third;
    }

    public void setThird(List<Cdcontent> third) {
        this.third = third;
    }
}
