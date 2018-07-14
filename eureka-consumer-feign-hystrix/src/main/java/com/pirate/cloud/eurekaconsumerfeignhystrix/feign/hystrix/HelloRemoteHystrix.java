package com.pirate.cloud.eurekaconsumerfeignhystrix.feign.hystrix;

import com.pirate.cloud.eurekaconsumerfeignhystrix.feign.HelloRemote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @项目名:eureka-server
 * @包名:com.pirate.cloud.eurekaconsumerfeignhystrix.feign.hystrix
 * @类名:HelloRemoteHystrix
 * @创建时间:2018/7/14 14:37
 * @创建人: AH_Pirate
 * @注释:
 */
@Component
public class HelloRemoteHystrix  implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World By Hystrix";
    }
}
