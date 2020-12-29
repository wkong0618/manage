package com.wk.manage.web.controller;

import com.wk.manage.biz.service.DemoService;
import com.wk.manage.common.bloom.RedisBloomTest;
import com.wk.manage.common.redis.CacheTime;
import com.wk.manage.common.redis.RedisClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@Api(tags = "manage-web")
public class DemoHelloController {
    @Autowired
    DemoService demoService;

    @Autowired
    RedisClient redisClient;

    @Autowired
    RedisBloomTest redisBloomTest;

    @GetMapping("test")
    @ApiOperation("test")
    public String test(){
        redisBloomTest.test();
        String k = demoService.test();
        redisClient.set("user:1", k, CacheTime.CACHE_EXP_MINUTE);
        System.out.println(redisClient.get("user:1").toString());
        return demoService.test();
    }
}
