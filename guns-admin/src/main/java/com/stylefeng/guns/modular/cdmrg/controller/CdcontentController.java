package com.stylefeng.guns.modular.cdmrg.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.Const;
import com.stylefeng.guns.core.support.DateTimeKit;
import com.stylefeng.guns.modular.cdcontent.service.ICdcontentClickService;
import com.stylefeng.guns.modular.system.model.CdcontentClick;
import com.stylefeng.guns.modular.system.model.HdcontentClick;
import com.stylefeng.guns.modular.system.warpper.CDcontentWapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Cdcontent;
import com.stylefeng.guns.modular.cdmrg.service.ICdcontentService;

import java.sql.Timestamp;

/**
 * 信用卡管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-21 22:23:53
 */
@Controller
@RequestMapping("/cdcontent")
public class CdcontentController extends BaseController {

    private String PREFIX = "/cdmrg/cdcontent/";

    @Autowired
    private ICdcontentService cdcontentService;
    @Autowired
    private ICdcontentClickService cdcontentClickService;
    /**
     * 跳转到信用卡管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "cdcontent.html";
    }

    /**
     * 跳转到添加信用卡管理
     */
    @RequestMapping("/cdcontent_add")
    public String cdcontentAdd() {
        return PREFIX + "cdcontent_add.html";
    }

    /**
     * 跳转到修改信用卡管理
     */
    @RequestMapping("/cdcontent_update/{cdcontentId}")
    public String cdcontentUpdate(@PathVariable Integer cdcontentId, Model model) {
        Cdcontent cdcontent = cdcontentService.selectById(cdcontentId);
        model.addAttribute("item",cdcontent);
        LogObjectHolder.me().set(cdcontent);
        return PREFIX + "cdcontent_edit.html";
    }

    /**
     * 获取信用卡管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String name, String type, String orderName) {
        return new CDcontentWapper(cdcontentService.findCdcontentByNameAndTypeOrder(name, type, orderName)).warp();
    }

    /**
     * 新增信用卡管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object add(Cdcontent cdcontent) {
        cdcontentService.insert(cdcontent);
        CdcontentClick entity = new CdcontentClick();
        entity.setCdid(cdcontent.getId());
        entity.setClick(0);
        Timestamp time = Timestamp.valueOf(DateTimeKit.now());
        entity.setLastclick(time);
        cdcontentClickService.insert(entity);
        return SUCCESS_TIP;
    }

    /**
     * 删除信用卡管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object delete(@RequestParam Integer cdcontentId) {
        cdcontentService.deleteById(cdcontentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改信用卡管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object update(Cdcontent cdcontent) {
        cdcontentService.updateById(cdcontent);
        return SUCCESS_TIP;
    }

    /**
     * 信用卡管理详情
     */
    @RequestMapping(value = "/detail/{cdcontentId}")
    @ResponseBody
    public Object detail(@PathVariable("cdcontentId") Integer cdcontentId) {
        return cdcontentService.selectById(cdcontentId);
    }
}
