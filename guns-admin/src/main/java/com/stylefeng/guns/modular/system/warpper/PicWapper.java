package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * @description: ${description}
 * @author: shengx
 * @create: 2018-05-19 22:59
 */
public class PicWapper extends BaseControllerWarpper {

    public PicWapper(List<Map<String, Object>> list) {
        super(list);
    }
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("typeName", ConstantFactory.me().getDictsByName("图片类型",(Integer)map.get("type")));
        map.put("openName", ConstantFactory.me().getDictsByName("图片状态",(Integer)map.get("open")));

    }
}
