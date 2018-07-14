package com.pirate.cloud.eurekaconsumerfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @项目名:eureka-server
 * @包名:com.pirate.cloud.eurekaconsumerfeign.feign
 * @类名:HelloRemote
 * @创建时间:2018/7/14 13:25
 * @创建人: AH_Pirate
 * @注释:
 */
@FeignClient(name="eureka-producer")
@Component //这里添加一个注释表示这个类在被调用的时候回自动创建一个实例
public interface HelloRemote {

    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);
}
