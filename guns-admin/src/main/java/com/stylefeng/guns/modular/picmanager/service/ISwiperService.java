package com.stylefeng.guns.modular.picmanager.service;

import com.stylefeng.guns.core.datascope.DataScope;
import com.stylefeng.guns.modular.system.model.Swiper;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-19
 */
public interface ISwiperService extends IService<Swiper> {
    /**
     * 根据条件查询用户列表
     */
    List<Map<String, Object>> selectSwiper(@Param("type") Integer type,@Param("open")Integer open);

    List<Swiper> selectSwiperByType(int type);

}
