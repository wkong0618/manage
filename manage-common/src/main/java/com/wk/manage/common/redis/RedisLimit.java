package com.wk.manage.common.redis;

import com.google.common.collect.Lists;
import com.wk.manage.common.util.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @Description : redis限流
 * @Author : wukong
 * @Date : 2022/4/9 6:26 下午
 */
@Component
@Slf4j
public class RedisLimit {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 限流lua
     */
    private static final String LIMIT_LUA;

    static {
        LIMIT_LUA = new StringBuilder()
                //限流key
                .append("local key = KEYS[1] ")
                //限流大小
                .append("local limit = tonumber(ARGV[1]) ")
                .append("local current = tonumber(redis.call('get', key) or '0') ")
                //如果超出限流大小
                .append("if current + 1 > limit then ")
                .append(" return 0 ")
                //请求数+1并设置2s过期
                .append("else ")
                .append("redis.call('INCRBY', key, '1') ")
                .append("redis.call('expire', key, '2') ")
                .append(" return 1")
                .append(" end").toString();
    }

    /**
     * 是否需要限流
     * @return
     */
    public boolean acquire(){
        Jedis jedis = jedisPool.getResource();
        try {
            //ip
            String key = IpUtils.getIp();
            //限流大小(分布式配置)
            String limit = "1000";
            return (Long) jedis.eval(LIMIT_LUA, Lists.newArrayList(key), Lists.newArrayList(limit)) == 1;
        } catch (Exception e) {
            log.error("是否需要限流异常", e);
        } finally {
            if(null != jedis){
                jedis.close();
            }
        }
        return false;
    }
}
