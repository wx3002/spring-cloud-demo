package com.pirate.cloud.eurekaconsumerfeign.controller;

import com.pirate.cloud.eurekaconsumerfeign.feign.HelloRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @项目名:eureka-server
 * @包名:com.pirate.cloud.eurekaconsumerfeign.controller
 * @类名:ConsumerFeignController
 * @创建时间:2018/7/14 13:27
 * @创建人: AH_Pirate
 * @注释:
 */
@RequestMapping("/hello")
@RestController
public class ConsumerFeignController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name){
        return helloRemote.hello(name+"!..");
    }
}
