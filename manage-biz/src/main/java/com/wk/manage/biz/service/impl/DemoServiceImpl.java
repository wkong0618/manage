package com.wk.manage.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wk.manage.biz.service.DemoService;
import com.wk.manage.common.redis.RedisDistributedLock;
import com.wk.manage.common.redis.RedisIdHelper;
import com.wk.manage.dao.mapper.AuthUsrMapper;
import com.wk.manage.idgen.RpcIdGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    @Autowired
    AuthUsrMapper authUsrMapper;

    @Autowired
    RedisDistributedLock distributedLock;

    @Autowired
    RedisIdHelper redisIdHelper;

    @Reference(group = "SnowflakeService")
    RpcIdGen rpcIdGen;

    @Override
    public String test() {
        String cc = rpcIdGen.get("1");
        return cc;
    }
}
