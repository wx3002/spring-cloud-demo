package com.pirate.cloud.eurekaconsumerribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @项目名:eureka-server
 * @包名:com.pirate.cloud.eurekaconsumerribbon.controller
 * @类名:ConsumerRibbonController
 * @创建时间:2018/7/14 13:12
 * @创建人: AH_Pirate
 * @注释:
 */
@RequestMapping("/hello")
@RestController
public class ConsumerRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name){
        //如果是通过消费者调用提供者就会在名字后面添加一个"!"
        name +="!";
        //ribbon的服务消费者直接调用服务提供者的名字即可调用掉该服务的内容,且ribbon已经提供了负载均衡
        String url = "http://eureka-producer/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);

    }
}
