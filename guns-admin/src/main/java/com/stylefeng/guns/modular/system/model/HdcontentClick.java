package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-20
 */
@TableName("sys_hdcontent_click")
public class HdcontentClick extends Model<HdcontentClick> {

    private static final long serialVersionUID = 1L;

    private Integer hdid;
    private Integer click;
    private Timestamp lastclick;


    public Integer getHdid() {
        return hdid;
    }

    public void setHdid(Integer hdid) {
        this.hdid = hdid;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Date getLastclick() {
        return lastclick;
    }

    public void setLastclick(Timestamp lastclick) {
        this.lastclick = lastclick;
    }

    @Override
    protected Serializable pkVal() {
        return this.hdid;
    }

    @Override
    public String toString() {
        return "HdcontentClick{" +
        "hdid=" + hdid +
        ", click=" + click +
        ", lastclick=" + lastclick +
        "}";
    }
}
