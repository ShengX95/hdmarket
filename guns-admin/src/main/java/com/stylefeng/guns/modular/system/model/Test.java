package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-15
 */
@TableName("sys_test")
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    private Integer test1;
    private String test2;


    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    @Override
    protected Serializable pkVal() {
        return this.test1;
    }

    @Override
    public String toString() {
        return "Test{" +
        "test1=" + test1 +
        ", test2=" + test2 +
        "}";
    }
}
