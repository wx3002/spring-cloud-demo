package com.pirate.cloud.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @项目名:eureka-server
 * @包名:com.pirate.cloud.eurekaconsumer.controller
 * @类名:ConsumerController
 * @创建时间:2018/7/14 10:56
 * @创建人: AH_Pirate
 * @注释:
 */
@RequestMapping("/hello")
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name){
        //如果是通过消费者调用提供者就会在名字后面添加一个"!"
        name +="!";
        ServiceInstance instance = client.choose("eureka-producer");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);

    }
}
