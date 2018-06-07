package com.stylefeng.guns.modular.picmanager.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.Const;
import com.stylefeng.guns.modular.system.warpper.PicWapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Swiper;
import com.stylefeng.guns.modular.picmanager.service.ISwiperService;

import java.util.List;
import java.util.Map;

/**
 * 图片展示管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-19 20:43:15
 */
@Controller
@RequestMapping("/swiper")
public class SwiperController extends BaseController {

    private String PREFIX = "/picmanager/swiper/";

    @Autowired
    private ISwiperService swiperService;

    /**
     * 跳转到图片展示管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "swiper.html";
    }

    /**
     * 跳转到添加图片展示管理
     */
    @RequestMapping("/swiper_add")
    public String swiperAdd() {
        return PREFIX + "swiper_add.html";
    }

    /**
     * 跳转到修改图片展示管理
     */
    @RequestMapping("/swiper_update/{swiperId}")
    public String swiperUpdate(@PathVariable Integer swiperId, Model model) {
        Swiper swiper = swiperService.selectById(swiperId);
        model.addAttribute("item",swiper);
        LogObjectHolder.me().set(swiper);
        return PREFIX + "swiper_edit.html";
    }

    /**
     * 获取图片展示管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Integer type, Integer open) {
        List<Map<String,Object>> list = swiperService.selectSwiper(type, open);
        return new PicWapper(list).warp();
    }
    /**
     * 新增图片展示管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object add(Swiper swiper) {
        swiperService.insert(swiper);
        return SUCCESS_TIP;
    }

    /**
     * 删除图片展示管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object delete(@RequestParam Integer swiperId) {
        swiperService.deleteById(swiperId);
        return SUCCESS_TIP;
    }

    /**
     * 修改图片展示管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object update(Swiper swiper) {
        swiperService.updateById(swiper);
        return SUCCESS_TIP;
    }

    /**
     * 图片展示管理详情
     */
    @RequestMapping(value = "/detail/{swiperId}")
    @ResponseBody
    public Object detail(@PathVariable("swiperId") Integer swiperId) {
        return swiperService.selectById(swiperId);
    }
}
