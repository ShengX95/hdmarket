package com.stylefeng.guns.modular.hdmrg.service.impl;

import com.stylefeng.guns.core.cache.CacheKit;
import com.stylefeng.guns.core.common.constant.cache.Cache;
import com.stylefeng.guns.modular.system.model.Hdcontent;
import com.stylefeng.guns.modular.system.dao.HdcontentMapper;
import com.stylefeng.guns.modular.hdmrg.service.IHdcontentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.model.HdcontentWapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shengx123
 * @since 2018-05-18
 */
@Service
public class HdcontentServiceImpl extends ServiceImpl<HdcontentMapper, Hdcontent> implements IHdcontentService {
    @Resource
    private HdcontentMapper hdcontentMapper;

    @Override
    public List<Hdcontent> findHdcontentByTypeOrder(int type) {
        return hdcontentMapper.selectHdcontentByTypeOrder(type);
    }

    @Override
    public List<Map<String, Object>> findHdcontent() {
        return hdcontentMapper.selectHdcontent();
    }

    @Override
    public List<Map<String, Object>> findHdcontentByNameAndTypeOrder(String name, String type, String orderName) {
        return hdcontentMapper.selectHdcontentByNameAndTypeOrder(name, type, orderName);
    }

    @Override
    public boolean insert(Hdcontent entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.HD_CONTENT);
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        CacheKit.remove(Cache.APISHOW, CacheKit.HD_CONTENT);
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(Hdcontent entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.HD_CONTENT);
        return super.updateById(entity);
    }

    @Override
    public HdcontentWapper findAllHdcontent() {
        HdcontentWapper hdw = null;
        if ((hdw = CacheKit.get(Cache.APISHOW, CacheKit.HD_CONTENT)) != null) {
            return hdw;
        } else {
            hdw = new HdcontentWapper();
            hdw.setFirst(hdcontentMapper.selectHdcontentByTypeOrder(1));
            hdw.setSecond(hdcontentMapper.selectHdcontentByTypeOrder(2));
            hdw.setThird(hdcontentMapper.selectHdcontentByTypeOrder(3));
            CacheKit.put(Cache.APISHOW, CacheKit.HD_CONTENT, hdw);
        }
        return hdw;
    }

}
