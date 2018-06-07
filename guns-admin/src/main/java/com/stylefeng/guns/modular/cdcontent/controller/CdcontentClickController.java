package com.stylefeng.guns.modular.cdcontent.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.CdcontentClick;
import com.stylefeng.guns.modular.cdcontent.service.ICdcontentClickService;

/**
 * 信用卡管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-21 22:43:09
 */
@Controller
@RequestMapping("/cdcontentClick")
public class CdcontentClickController extends BaseController {

    private String PREFIX = "/cdcontent/cdcontentClick/";

    @Autowired
    private ICdcontentClickService cdcontentClickService;

    /**
     * 跳转到信用卡管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "cdcontentClick.html";
    }

    /**
     * 跳转到添加信用卡管理
     */
    @RequestMapping("/cdcontentClick_add")
    public String cdcontentClickAdd() {
        return PREFIX + "cdcontentClick_add.html";
    }

    /**
     * 跳转到修改信用卡管理
     */
    @RequestMapping("/cdcontentClick_update/{cdcontentClickId}")
    public String cdcontentClickUpdate(@PathVariable Integer cdcontentClickId, Model model) {
        CdcontentClick cdcontentClick = cdcontentClickService.selectById(cdcontentClickId);
        model.addAttribute("item",cdcontentClick);
        LogObjectHolder.me().set(cdcontentClick);
        return PREFIX + "cdcontentClick_edit.html";
    }

    /**
     * 获取信用卡管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return cdcontentClickService.selectList(null);
    }

    /**
     * 新增信用卡管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CdcontentClick cdcontentClick) {
        cdcontentClickService.insert(cdcontentClick);
        return SUCCESS_TIP;
    }

    /**
     * 删除信用卡管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer cdcontentClickId) {
        cdcontentClickService.deleteById(cdcontentClickId);
        return SUCCESS_TIP;
    }

    /**
     * 修改信用卡管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CdcontentClick cdcontentClick) {
        cdcontentClickService.updateById(cdcontentClick);
        return SUCCESS_TIP;
    }

    /**
     * 信用卡管理详情
     */
    @RequestMapping(value = "/detail/{cdcontentClickId}")
    @ResponseBody
    public Object detail(@PathVariable("cdcontentClickId") Integer cdcontentClickId) {
        return cdcontentClickService.selectById(cdcontentClickId);
    }
}
