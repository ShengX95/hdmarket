package com.stylefeng.guns.modular.hdmrg.service;

import com.stylefeng.guns.modular.system.model.Hdcontent;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.HdcontentWapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shengx123
 * @since 2018-05-18
 */
public interface IHdcontentService extends IService<Hdcontent> {
    List<Hdcontent> findHdcontentByTypeOrder(int type);
    List<Map<String,Object>> findHdcontent();
    List<Map<String,Object>> findHdcontentByNameAndTypeOrder(String name,String type, String orderName);
    HdcontentWapper findAllHdcontent();
}
