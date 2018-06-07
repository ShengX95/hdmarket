package com.stylefeng.guns.modular.hdcontent.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.HdcontentClick;
import com.stylefeng.guns.modular.hdcontent.service.IHdcontentClickService;

/**
 * 货代点击率控制器
 *
 * @author fengshuonan
 * @Date 2018-05-20 22:50:19
 */
@Controller
@RequestMapping("/hdcontentClick")
public class HdcontentClickController extends BaseController {

    private String PREFIX = "/hdcontent/hdcontentClick/";

    @Autowired
    private IHdcontentClickService hdcontentClickService;

    /**
     * 跳转到货代点击率首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hdcontentClick.html";
    }

    /**
     * 跳转到添加货代点击率
     */
    @RequestMapping("/hdcontentClick_add")
    public String hdcontentClickAdd() {
        return PREFIX + "hdcontentClick_add.html";
    }

    /**
     * 跳转到修改货代点击率
     */
    @RequestMapping("/hdcontentClick_update/{hdcontentClickId}")
    public String hdcontentClickUpdate(@PathVariable Integer hdcontentClickId, Model model) {
        HdcontentClick hdcontentClick = hdcontentClickService.selectById(hdcontentClickId);
        model.addAttribute("item",hdcontentClick);
        LogObjectHolder.me().set(hdcontentClick);
        return PREFIX + "hdcontentClick_edit.html";
    }

    /**
     * 获取货代点击率列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return hdcontentClickService.selectList(null);
    }

    /**
     * 新增货代点击率
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(HdcontentClick hdcontentClick) {
        hdcontentClickService.insert(hdcontentClick);
        return SUCCESS_TIP;
    }

    /**
     * 删除货代点击率
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer hdcontentClickId) {
        hdcontentClickService.deleteById(hdcontentClickId);
        return SUCCESS_TIP;
    }

    /**
     * 修改货代点击率
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(HdcontentClick hdcontentClick) {
        hdcontentClickService.updateById(hdcontentClick);
        return SUCCESS_TIP;
    }

    /**
     * 货代点击率详情
     */
    @RequestMapping(value = "/detail/{hdcontentClickId}")
    @ResponseBody
    public Object detail(@PathVariable("hdcontentClickId") Integer hdcontentClickId) {
        return hdcontentClickService.selectById(hdcontentClickId);
    }
}
