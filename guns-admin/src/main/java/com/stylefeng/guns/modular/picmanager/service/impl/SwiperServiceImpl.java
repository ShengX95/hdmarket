package com.stylefeng.guns.modular.picmanager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.cache.CacheKit;
import com.stylefeng.guns.core.common.constant.cache.Cache;
import com.stylefeng.guns.modular.system.model.Swiper;
import com.stylefeng.guns.modular.system.dao.SwiperMapper;
import com.stylefeng.guns.modular.picmanager.service.ISwiperService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-19
 */
@Service
public class SwiperServiceImpl extends ServiceImpl<SwiperMapper, Swiper> implements ISwiperService {
    @Override
    public boolean insert(Swiper entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.PIC_CONTENT + entity.getType());
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        CacheKit.remove(Cache.APISHOW, CacheKit.PIC_CONTENT + 1);
        CacheKit.remove(Cache.APISHOW, CacheKit.PIC_CONTENT + 2);
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(Swiper entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.PIC_CONTENT + entity.getType());
        return super.updateById(entity);
    }

//    @Override
//    public List<Swiper> selectList(Wrapper<Swiper> wrapper) {
//
//        List<Swiper> result = null;
//        if ((result = CacheKit.get(Cache.APISHOW, CacheKit.PIC_CONTENT)) != null) {
//            return result;
//        } else {
//            result = super.selectList(wrapper);
//            CacheKit.put(Cache.APISHOW, CacheKit.PIC_CONTENT, result);
//        }
//        return result;
//    }

    @Override
    public List<Swiper> selectSwiperByType(int type) {
        List<Swiper> result = null;
        String cacheKey = CacheKit.PIC_CONTENT + type;
        if ((result = CacheKit.get(Cache.APISHOW, cacheKey)) != null) {
            return result;
        } else {
            result = super.selectList(new EntityWrapper<Swiper>().eq("type", type).eq("open", 1));
            CacheKit.put(Cache.APISHOW, cacheKey, result);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> selectSwiper(Integer type, Integer open) {
        return this.baseMapper.selectSwiper(type, open);
    }
}
