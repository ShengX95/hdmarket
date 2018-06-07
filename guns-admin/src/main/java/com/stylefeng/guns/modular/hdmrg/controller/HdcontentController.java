package com.stylefeng.guns.modular.hdmrg.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.Const;
import com.stylefeng.guns.core.support.DateTime;
import com.stylefeng.guns.core.support.DateTimeKit;
import com.stylefeng.guns.modular.hdcontent.service.IHdcontentClickService;
import com.stylefeng.guns.modular.system.model.HdcontentClick;
import com.stylefeng.guns.modular.system.warpper.HDcontentWapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Hdcontent;
import com.stylefeng.guns.modular.hdmrg.service.IHdcontentService;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 货代管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-18 20:36:21
 */
@Controller
@RequestMapping("/hdcontent")
public class HdcontentController extends BaseController {

    private String PREFIX = "/hdmrg/hdcontent/";

    @Autowired
    private IHdcontentService hdcontentService;

    @Autowired
    private IHdcontentClickService hdcontentClickService;

    /**
     * 跳转到货代管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hdcontent.html";
    }

    /**
     * 跳转到添加货代管理
     */
    @RequestMapping("/hdcontent_add")
    public String hdcontentAdd() {
        return PREFIX + "hdcontent_add.html";
    }

    /**
     * 跳转到修改货代管理
     */
    @RequestMapping("/hdcontent_update/{hdcontentId}")
    public String hdcontentUpdate(@PathVariable Integer hdcontentId, Model model) {
        Hdcontent hdcontent = hdcontentService.selectById(hdcontentId);
        model.addAttribute("item",hdcontent);
        LogObjectHolder.me().set(hdcontent);
        return PREFIX + "hdcontent_edit.html";
    }

    /**
     * @param name  货代名称
     * @param type  类型
     * @return  list
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String name, String type, String orderName) {
        System.out.println(name + type);
        return new HDcontentWapper(hdcontentService.findHdcontentByNameAndTypeOrder(name, type, orderName)).warp();
    }

    /**
     * 新增货代管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object add(Hdcontent hdcontent) {
        hdcontentService.insert(hdcontent);
        HdcontentClick entity = new HdcontentClick();
        entity.setHdid(hdcontent.getId());
        entity.setClick(0);
        Timestamp time = Timestamp.valueOf(DateTimeKit.now());
        entity.setLastclick(time);
        hdcontentClickService.insert(entity);
        return SUCCESS_TIP;
    }

    /**
     * 删除货代管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object delete(@RequestParam Integer hdcontentId) {
        hdcontentService.deleteById(hdcontentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改货代管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @Permission({Const.ADMIN_NAME,Const.CONTENT_NAME})
    public Object update(Hdcontent hdcontent) {
        hdcontentService.updateById(hdcontent);
        return SUCCESS_TIP;
    }

    /**
     * 货代管理详情
     */
    @RequestMapping(value = "/detail/{hdcontentId}")
    @ResponseBody
    public Object detail(@PathVariable("hdcontentId") Integer hdcontentId) {
        return hdcontentService.selectById(hdcontentId);
    }
}
