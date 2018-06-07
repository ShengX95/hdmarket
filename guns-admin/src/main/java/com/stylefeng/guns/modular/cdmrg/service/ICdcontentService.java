package com.stylefeng.guns.modular.cdmrg.service;

import com.stylefeng.guns.modular.system.model.Cdcontent;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.CdcontentWapper;
import com.stylefeng.guns.modular.system.model.Hdcontent;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信用卡 服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-21
 */
public interface ICdcontentService extends IService<Cdcontent> {
    List<Cdcontent> findCdcontentByTypeOrder(int type);
    List<Map<String,Object>> findCdcontent();
    List<Map<String,Object>> findCdcontentByNameAndTypeOrder(String name,String type, String orderName);
    CdcontentWapper findAllCdcontent();
}
