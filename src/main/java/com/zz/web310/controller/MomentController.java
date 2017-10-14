package com.zz.web310.controller;

import com.zz.web310.entity.Moment;
import com.zz.web310.repo.IMomentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    private IMomentRepo momentRepo;

    @RequestMapping(value="",method = RequestMethod.POST)
    //更新后value就不用写save了
    public Moment saveMoment(@RequestBody Moment moment){
        moment = momentRepo.save(moment);
        //momentRepo.saveAndFlush(moment);//这个执行完马上写入数据库
        //因为后台有一个TransactionManager帮你去管理对象的存储，
        // 如果有事务的话，会把数据交给数据库，当确认一切okay的时候，最后在提交。
        //当多线程，比如说购买，抢资源的时候就用saveAndFlush
        return moment;
    }



    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean deleteMoment(@RequestBody Moment moment) {
        momentRepo.delete(moment);
        return true;
    }


    @RequestMapping(value = "/{momentId}", method = RequestMethod.DELETE)
    public Boolean deleteMoment(@PathVariable Integer momentId) {
        momentRepo.delete(momentId);
        return Boolean.TRUE;
    }

    @RequestMapping(value = "/{momentId}", method = RequestMethod.GET)
    public Moment getMoment(@PathVariable Integer momentId) {
        Moment result= momentRepo.findOne(momentId);
        return result;
    }

}
