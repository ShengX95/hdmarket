package com.stylefeng.guns.modular.cdmrg.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.cache.CacheKit;
import com.stylefeng.guns.core.common.constant.cache.Cache;
import com.stylefeng.guns.modular.system.model.Cdcontent;
import com.stylefeng.guns.modular.system.dao.CdcontentMapper;
import com.stylefeng.guns.modular.cdmrg.service.ICdcontentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.model.CdcontentWapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信用卡 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-21
 */
@Service
public class CdcontentServiceImpl extends ServiceImpl<CdcontentMapper, Cdcontent> implements ICdcontentService {
    @Resource
    private CdcontentMapper cdcontentMapper;
    private static final String picCtx = "/static/images/";

    @Override
    public List<Cdcontent> findCdcontentByTypeOrder(int type) {
        return cdcontentMapper.selectCdcontentByTypeOrder(type);
    }

    @Override

    public List<Map<String, Object>> findCdcontent() {
        return cdcontentMapper.selectCdcontent();
    }

    @Override
    public List<Map<String, Object>> findCdcontentByNameAndTypeOrder(String name, String type, String orderName) {
        return cdcontentMapper.selectCdcontentByNameAndTypeOrder(name, type, orderName);
    }

    @Override
    public boolean insert(Cdcontent entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.CD_CONTENT);
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        CacheKit.remove(Cache.APISHOW, CacheKit.CD_CONTENT);
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(Cdcontent entity) {
        CacheKit.remove(Cache.APISHOW, CacheKit.CD_CONTENT);
        return super.updateById(entity);
    }

    @Override
    public CdcontentWapper findAllCdcontent() {
        CdcontentWapper cdw = null;

        if((cdw = CacheKit.get(Cache.APISHOW, CacheKit.CD_CONTENT)) != null){
            return cdw;
        }else {
            cdw = new CdcontentWapper();
            // 图片路径修改
            List<Cdcontent> list1 = cdcontentMapper.selectCdcontentByTypeOrder(1);
            for(Cdcontent cd : list1){
                cd.setUrl(picCtx + cd.getUrl());
            }
            cdw.setFirst(list1);
            List<Cdcontent> list2 = cdcontentMapper.selectCdcontentByTypeOrder(2);
            for(Cdcontent cd : list2){
                cd.setUrl(picCtx + cd.getUrl());
            }
            cdw.setSecond(list2);
            List<Cdcontent> list3 = cdcontentMapper.selectCdcontentByTypeOrder(3);
            for(Cdcontent cd : list3){
                cd.setUrl(picCtx + cd.getUrl());
            }
            cdw.setThird(list3);
            CacheKit.put(Cache.APISHOW, CacheKit.CD_CONTENT, cdw);
        }
        return cdw;
    }
}
