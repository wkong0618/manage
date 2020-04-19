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
       /* String requireToken = distributedLock.acquire(CacheKeysEnum.TEST.key(), 60000);
        distributedLock.release(CacheKeysEnum.TEST.key(), requireToken);
        String serialNo = redisIdHelper.generateSerialNo(CacheKeysEnum.TEST.key(), "", "");
        log.info("generate serialNo:{}", serialNo);
        return authUsrMapper.selectByPrimaryKey("160825000001").getUsrName();*/
    }

    public static void main(String[] args) {
        List<AuthProtocolInfo> authProtocolInfos = new ArrayList<>();
        AuthProtocolInfo a = new AuthProtocolInfo();
        a.setBindCardTime("1578918820");
        AuthProtocolInfo b = new AuthProtocolInfo();
        b.setBindCardTime("1578917970");
        authProtocolInfos.add(a);
        authProtocolInfos.add(b);
        authProtocolInfos.sort((item1, item2) -> new BigDecimal(item2.getBindCardTime()).compareTo(new BigDecimal(item1.getBindCardTime())));
        System.out.printf(authProtocolInfos.get(0).getBindCardTime());
    }
}
