package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 信用卡
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-21
 */
@TableName("sys_cdcontent")
public class Cdcontent extends Model<Cdcontent> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 额度
     */
    @TableField("limit_time")
    private String limitTime;
    /**
     * 详情
     */
    private String detail;
    /**
     * 信用卡名称
     */
    private String title;
    /**
     * 图片URL
     */
    private String url;
    /**
     * 展示顺序
     */
    @TableField("show_order")
    private Integer showOrder;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 跳转URL
     */
    private String tourl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTourl() {
        return tourl;
    }

    public void setTourl(String tourl) {
        this.tourl = tourl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Cdcontent{" +
        "id=" + id +
        ", limitTime=" + limitTime +
        ", detail=" + detail +
        ", title=" + title +
        ", url=" + url +
        ", showOrder=" + showOrder +
        ", type=" + type +
        ", createTime=" + createTime +
        ", tourl=" + tourl +
        "}";
    }
}
