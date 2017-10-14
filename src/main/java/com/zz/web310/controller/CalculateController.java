package com.zz.web310.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//这个类是提供路由方法：服务器接收信息之后，把信息分发给不同设备；分发的时候需要路径
@RequestMapping(value = "/calculate")//提供路由规则，如果url start with calcuate 就可以进入
//http://localhost:8080/calculate/add
public class CalculateController {

    @RequestMapping(value = "/add")//先进入calculate，然后进入add
    public Integer add(Integer v1, Integer v2){
        System.out.println("==========");
        if(v1 == null || v2 ==null){
            return 0;
        }
        return v1+v2;
        //http://localhost:8080/calculate/add?v1=2&v2=3
        //

    }
    @RequestMapping(value = "/add/{v1}/{v2}")
    public Integer add2(@PathVariable Integer v1,
                        @PathVariable Integer v2) {
        if (v1 == null || v2 == null) {
            return 0;
        }
        System.out.println("========");
        return v1 + v2;
        //http://localhost:8080/calculate/add/3/3
    }

    @RequestMapping(value = "/sum")
    public Integer sum(@RequestParam List<Integer> sumList) {
        if (sumList == null || sumList.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int value : sumList) {
            sum = sum + value;
        }
        return sum;
    }

}
