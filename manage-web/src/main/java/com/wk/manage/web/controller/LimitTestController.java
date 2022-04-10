package com.wk.manage.web.controller;

import com.wk.manage.common.redis.RedisLimit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 限流
 * @Author : wukong
 * @Date : 2022/4/9 6:44 下午
 */
@Slf4j
@RestController
@RequestMapping("limit")
@Api(tags = "manage-web")
public class LimitTestController {
    @Autowired
    private RedisLimit redisLimit;

    @GetMapping("test")
    @ApiOperation("test")
    public String test(){
        boolean acquire = redisLimit.acquire();
        if(!acquire){
            log.info("limit fail");
            return "limit fail";
        }
        log.info("executing...");
        return "success";
    }
}
