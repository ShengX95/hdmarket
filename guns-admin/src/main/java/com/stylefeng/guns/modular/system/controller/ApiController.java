package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.support.DateTimeKit;
import com.stylefeng.guns.core.util.FileUtil;
import com.stylefeng.guns.modular.cdcontent.service.ICdcontentClickService;
import com.stylefeng.guns.modular.cdmrg.service.ICdcontentService;
import com.stylefeng.guns.modular.hdcontent.service.IHdcontentClickService;
import com.stylefeng.guns.modular.hdmrg.service.IHdcontentService;
import com.stylefeng.guns.modular.picmanager.service.ISwiperService;
import com.stylefeng.guns.modular.system.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: ${description}
 * @author: shengx
 * @create: 2018-05-20 17:05
 */
//@CrossOrigin(origins = "http://118.31.10.18", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api/show")
public class ApiController extends BaseController {
    @Autowired
    private GunsProperties gunsProperties;
    @Autowired
    private IHdcontentService hdcontentService;
    @Autowired
    private ICdcontentService cdcontentService;
    @Autowired
    private ISwiperService swiperService;
    @Autowired
    private IHdcontentClickService hdcontentClickService;
    @Autowired
    private ICdcontentClickService cdcontentClickService;
    private static final String picCtx = "/static/images/";
    //private static final String picCtx = "http://localhost:8081/api/show/pic/";

    /**
     * 获取所有货代
     * @return  wapper
     */
    @GetMapping("/hdcontent/all")
    public Object getAllHdcontent(){
        return hdcontentService.findAllHdcontent();
    }

    /**
     * 获取所有信用卡
     * @return  wapper
     */
    @GetMapping("/cdcontent/all")
    public Object getAllCdcontent(){
        return cdcontentService.findAllCdcontent();
    }

    /**
     * 根据货代类型返回列表
     * @param type  1:最新入驻平台 2:平台力荐 3:下款最快
     * @return  对应货代类型
     */
    @GetMapping("/hdcontent/{type}")
    public List<Hdcontent> getHdcontent(@PathVariable("type") int type){
        return hdcontentService.findHdcontentByTypeOrder(type);
    }

    /**
     * 根据信用卡类型返回列表
     * @param type  1:点击最多 2:发款最快 3:最新发布
     * @return 对应信用卡类型
     */
    @GetMapping("/cdcontent/{type}")
    public List<Cdcontent> getCdcontent(@PathVariable("type") int type){
        List<Cdcontent> list = cdcontentService.findCdcontentByTypeOrder(type);
        for(Cdcontent cd : list){
            cd.setUrl(picCtx + cd.getUrl());
        }
        return list;
    }

    /**
     * 根据类型返回对应swiper
     * @param type  1:货代,2:信用卡
     * @return  列表
     */
    @GetMapping("/swiper/{type}")
    public List<SwiperShow> getSwiper(@PathVariable String type){
        Integer typeName=null;
        if(type.equals("huodai")){
            typeName=1;
        }else {
            typeName = 2;
        }
        List<Swiper> list = swiperService.selectSwiperByType(typeName);
        List<SwiperShow> result = new ArrayList<>();
        for (Swiper sw:list){
            SwiperShow ss = new SwiperShow();
            ss.setId(sw.getId());
            ss.setImg(picCtx + sw.getUrl());
            ss.setTitle(sw.getTitle());
            ss.setUrl(sw.getTourl());
            result.add(ss);
        }
        return result;
    }

    /**
     * 点击量统计
     * @param type  huodai || creditcard
     * @param id    对应id
     * @return  tip
     */
    @GetMapping("/click/{type}/{id}")
    public Object click(@PathVariable String type,@PathVariable int id){
        if(type.equals("huodai")){
            HdcontentClick click = new HdcontentClick();
            int clicktime = hdcontentClickService.selectOne(new EntityWrapper<HdcontentClick>().eq("hdid",id)).getClick();
            click.setClick(clicktime+1);
            click.setLastclick(Timestamp.valueOf(DateTimeKit.now()));
            hdcontentClickService.update(click,new EntityWrapper<HdcontentClick>().eq("hdid",id));
        }else if(type.equals("creditcard")){
            CdcontentClick click = new CdcontentClick();
            int clicktime = cdcontentClickService.selectOne(new EntityWrapper<CdcontentClick>().eq("cdid",id)).getClick();
            click.setClick(clicktime+1);
            click.setLastclick(Timestamp.valueOf(DateTimeKit.now()));
            cdcontentClickService.update(click,new EntityWrapper<CdcontentClick>().eq("cdid",id));
        }
        return SUCCESS_TIP;
    }
    /**
     * 返回图片
     * @author stylefeng
     * @Date 2017/5/24 23:00
     */
    @RequestMapping("/pic/{pictureId}")
    public void returnPicture(@PathVariable("pictureId") String pictureId, HttpServletResponse response) {
        String path = gunsProperties.getFileUploadPath() + pictureId + ".jpg";
        try {
            byte[] bytes = FileUtil.toByteArray(path);
            response.getOutputStream().write(bytes);
        }catch (Exception e){
            //如果找不到图片就返回一个默认图片
            try {
                response.sendRedirect("/static/img/girl.gif");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
