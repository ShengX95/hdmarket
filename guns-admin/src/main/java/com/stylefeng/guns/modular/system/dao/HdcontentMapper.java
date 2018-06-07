package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.modular.system.model.Hdcontent;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shengx123
 * @since 2018-05-18
 */
public interface HdcontentMapper extends BaseMapper<Hdcontent> {
    /**
     * 根据类型选择所有展示内容
     * @param type 0:最新入驻平台 1:平台力荐 2:下款最快
     * @return 内容
     */
    List<Hdcontent> selectHdcontentByTypeOrder(@Param("type") int type);

    /**
     * 查找所有内容
     * @return 内容
     */
    List<Map<String, Object>> selectHdcontent();

    /**
     * 根据货代名称和类型查询内容
     * @param name  货代名称
     * @param type  类型
     * @param orderName 排序字段
     * @return  内容
     */
    List<Map<String, Object>> selectHdcontentByNameAndTypeOrder(@Param("title") String name, @Param("type") String type, @Param("showOrder") String orderName);

}
