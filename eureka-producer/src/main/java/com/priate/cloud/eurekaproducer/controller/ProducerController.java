package com.priate.cloud.eurekaproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

/**
 * @项目名:eureka-server
 * @包名:com.priate.cloud.eurekaproducer.controller
 * @类名:ProducerController
 * @创建时间:2018/7/14 12:56
 * @创建人: AH_Pirate
 * @注释:
 */
@RestController
@RequestMapping("/hello")
public class ProducerController {

//    @GetMapping("/")
//    public String hello(@RequestParam String name){
//        return "Hello,你好:" + name + " 时间:" + new Date();
//    }
/*----------------------- 为了验证负载均衡我们引用了以下方法 -----------------------*/

    @Value("${config.producer.instance:0}")
    private int instance;

    @GetMapping("/")
    public String hello(@RequestParam String name){
        return "[" + instance + "]" + "Hello," + name + ",来看看我的[]内容,现在时间是:   " + DateFormat.getDateTimeInstance().format(new Date());
    }
}
