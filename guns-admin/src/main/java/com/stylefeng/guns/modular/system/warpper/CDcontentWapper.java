package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * @description: ${description}
 * @author: shengx
 * @create: 2018-05-20 17:29
 */
public class CDcontentWapper extends BaseControllerWarpper {

    public CDcontentWapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("typeName", ConstantFactory.me().getDictsByName("信用卡类型",(Integer)map.get("type")));
        map.put("click",ConstantFactory.me().getCDClick((Integer)map.get("id")).getClick());
    }
}
