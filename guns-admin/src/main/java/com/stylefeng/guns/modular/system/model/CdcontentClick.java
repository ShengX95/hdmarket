package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

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
 * @since 2018-05-21
 */
@TableName("sys_cdcontent_click")
public class CdcontentClick extends Model<CdcontentClick> {

    private static final long serialVersionUID = 1L;

    private Integer cdid;
    private Integer click;
    private Date lastclick;


    public Integer getCdid() {
        return cdid;
    }

    public void setCdid(Integer cdid) {
        this.cdid = cdid;
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

    public void setLastclick(Date lastclick) {
        this.lastclick = lastclick;
    }

    @Override
    protected Serializable pkVal() {
        return this.cdid;
    }

    @Override
    public String toString() {
        return "CdcontentClick{" +
        "cdid=" + cdid +
        ", click=" + click +
        ", lastclick=" + lastclick +
        "}";
    }
}
