package com.zz.web310.controller;

import com.zz.web310.entity.Moments;
import com.zz.web310.service.IMomentsService;
import com.zz.web310.service.MomentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pyq")
public class MomentsController {
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    private Moments postPengYouQuan(@RequestBody Moments pyq) {
        if (pyq == null) {
            Moments pengYouQuan = new Moments();
            pengYouQuan.setUser("NoBody");
            return pengYouQuan;
        }
        return pyq;
    }

    @Autowired//现在需要一个实现IMomentsService接口的类，然后Spring就去找，哪个类实现了这个接口
    //找的时候就会【特别关注】@service,@bean，创建了对象，然后返回
    //auotowire 相当于 applicationContext.getBean(IMomentsService.class)
    @Qualifier(value = "pengyouquan")
    //如果有两个类都实现了这个接口怎么办呢？就用Qualifier进行区分
    private IMomentsService momentsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    //把save作为url的一部分其实很不好，没有效率，可以把它规整成一个总的大方法比如info
    //然后通过不同的RequestMethod.*来实现不同的方法
    //Post添加新的值，Get取值，Delete删除
    public Moments saveMoments(@RequestBody Moments moments){
        if (moments !=null){
            System.out.println(moments.getUser());
            return momentsService.saveMoments(moments);
        }
        return null;
    }

    @RequestMapping(value ="/info/{userName}",method = RequestMethod.POST)
    public Moments saveMoments2(@PathVariable String userName,
                                @RequestBody Moments moments){
        if(moments!=null){
            System.out.println(moments.getUser());
            moments.setUser(userName);
            return momentsService.saveMoments(moments);
        }
        return null;
    }
    //http://localhost:8080/pyq/info/“wendong”

    @RequestMapping(value ="/info/{userName}",method = RequestMethod.GET)
    public Moments getMoments(@PathVariable String userName){
        return momentsService.getMoments(userName);
    }

    @RequestMapping(value ="/info/{userName",method = RequestMethod.DELETE)
    public Boolean deleteMoments(@PathVariable String userName){
        return momentsService.deleteMoments(userName);
    }



}