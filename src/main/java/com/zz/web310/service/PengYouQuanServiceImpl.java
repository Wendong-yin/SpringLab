package com.zz.web310.service;

import com.zz.web310.entity.PengYouQuan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service(value = "pyq") //create bean pengyouquanserviceImpl name pyq
//@Bean
public class PengYouQuanServiceImpl implements IPengYouQuanService {

    private Map<String, PengYouQuan> pengYouQuanHolder;

    @PostConstruct //1.create bean 2. invoke postConstruct method  //Construct() -> postConstruct()
    private void init() {
        pengYouQuanHolder = new HashMap<String, PengYouQuan>();
        //invoke another method
    }

    @Override
    public PengYouQuan savePengYouQuan(PengYouQuan pengYouQuan) {
        if (pengYouQuan == null || pengYouQuan.getUser() == null) {
            return null;
        }
        String user = pengYouQuan.getUser();
        pengYouQuanHolder.put(user, pengYouQuan);
        return pengYouQuan;
    }

    @Override
    public PengYouQuan getPengYouQuan(String userName) {
        return pengYouQuanHolder.get(userName);
    }

    @Override
    public Boolean deletePengYouQuan(String userName) {
        if (pengYouQuanHolder.containsKey(userName)) {
            pengYouQuanHolder.remove(userName);
            return true;
        }
        return false;
    }

}
