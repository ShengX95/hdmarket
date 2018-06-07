package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Cdcontent;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.impl.PerpetualCache;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信用卡 Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-21
 */
public interface CdcontentMapper extends BaseMapper<Cdcontent> {
    /**
     * 根据类型选择所有展示内容
     * @param type 0:点击最多 1:发款最快 2:最新发布
     * @return 内容
     */
    List<Cdcontent> selectCdcontentByTypeOrder(@Param("type") int type);

    /**
     * 查找所有内容
     * @return 内容
     */
    List<Map<String, Object>> selectCdcontent();

    /**
     * 根据货代名称和类型查询内容
     * @param name  信用卡名称
     * @param type  类型
     * @param orderName 排序字段
     * @return  内容
     */
    List<Map<String, Object>> selectCdcontentByNameAndTypeOrder(@Param("title") String name, @Param("type") String type, @Param("showOrder") String orderName);
}
