package com.zz.web310.controller;

import com.zz.web310.entity.PengYouQuan;
import com.zz.web310.service.IPengYouQuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pyq2")
public class PengYouQuanController {


    //GET  POST

    //request  -> requestbody
    //request -> json -> java instance
    // request
    //   |- header
    //   |- path
    //   |- param
    //   |- body
    @RequestMapping(value = "/info1", method = RequestMethod.POST)
    public PengYouQuan postPengYouQuan(@RequestBody PengYouQuan pyq) {
        if (pyq == null) {
            PengYouQuan pengYouQuan = new PengYouQuan();
            pengYouQuan.setUser("NoBody");
            return pengYouQuan;
        }
        return pyq;
    }


    //  applicationContext.getBean(IPengyouQuanService.class)
    @Autowired
    @Qualifier(value = "pyq") //applicationContext.getBean(name="pyq")
    private IPengYouQuanService pengYouQuanService;


    // controller -> handle request
    // request -> dispatch requestParam to service

    //1.controller
    //2.service
    //3.repo


    // /pyq/info/      userName:pyq Instance
    @RequestMapping(value = "/info/{userName}", method = RequestMethod.POST)
    public PengYouQuan savePengYouQuan(@PathVariable String userName,
                                       @RequestBody PengYouQuan pengYouQuan) {
        if (pengYouQuan != null) {
            System.out.println(pengYouQuan.getUser());
            pengYouQuan.setUser(userName);
            return pengYouQuanService.savePengYouQuan(pengYouQuan);
        }
        return null;
    }

    @RequestMapping(value = "/info/{userName}", method = RequestMethod.GET)
    public PengYouQuan getPengYouQuan(@PathVariable String userName) {
        return pengYouQuanService.getPengYouQuan(userName);
    }
    // Http 规范里  DELETE  no param
    @RequestMapping(value = "/info/{userName}", method = RequestMethod.DELETE)
    public Boolean deletePengYouQuan(@PathVariable String userName) {
        return pengYouQuanService.deletePengYouQuan(userName);
    }

    //1.GET 获取数据    查
    //2.POST 上传数据/更新数据  改/增
    //3.DELETE 删除行为   删
    //4.PUT 更新行为（必须是幂等） 增/改  HTTP规范
    //5.OPTION  -> get method list (GET/POST)
}
