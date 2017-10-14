package com.zz.web310.service;

import com.zz.web310.entity.Moments;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service(value = "pengyouquan")//注意这个放在了Class上面，@Bean放在Method上面，他们的功能差不多：
//一个查找的标志，帮助创造对象，创造了对象，然后然后返回这个对象
public class MomentsServiceImpl implements IMomentsService {
    private Map<String, Moments> momentsHolder;

    @PostConstruct//为什么是Consturct？因为创建Bean之后，先调用Constructer，紧接着调用这个方法
    //所以这个叫postConstruct
    private void init(){
        momentsHolder = new HashMap<String, Moments>();
    }

    @Override
    public Moments saveMoments(Moments moments){
        if (moments == null || moments.getUser() == null){
            return null;
        }
        String user = moments.getUser();
        momentsHolder.put(user,moments);
        return moments;
    }

    @Override
    public Moments getMoments(String userName) {
        return momentsHolder.get(userName);
    }

    @Override
    public Boolean deleteMoments(String userName) {
        if(momentsHolder.containsKey(userName)){
            momentsHolder.remove(userName);
            return true;
        }
        return false;
    }

}
