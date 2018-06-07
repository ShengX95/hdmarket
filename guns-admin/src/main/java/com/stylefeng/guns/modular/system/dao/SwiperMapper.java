package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.modular.system.model.Swiper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-19
 */
public interface SwiperMapper extends BaseMapper<Swiper> {
    List<Map<String, Object>> selectSwiper(@Param("type") Integer type,@Param("open")Integer open);
}
