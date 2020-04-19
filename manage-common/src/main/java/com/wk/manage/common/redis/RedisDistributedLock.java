package com.wk.manage.common.redis;

import com.wk.manage.common.redis.service.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

/**
 * 描述:
 * 分布式锁实现(单机redis)
 * 实现分布式锁，需要同时满足以下四个条件：
 * 1.互斥性 任意时刻只有一个客户端可以持有锁(nx)
 * 2.避免死锁 即使一个客户端持有锁的期间崩溃而没有主动释放锁，也需要保证后续其它客户端能够加锁成功(expireTime)
 * 3.加锁和解锁必须是同一个客户端，客户端自己不能把别人的加的锁给释放掉(value唯一标识)
 * 4.容错性 只要大部分的redis节点正常运行，客户端就可以进行加锁和解锁操作
 * @author wukong
 * @create 2020-03-22 下午2:04
 */
@Service
@Slf4j
public class RedisDistributedLock implements DistributedLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String RELEASE_SUCCESS = "1";
    private static  String RELEASE_LUA;
    /**
     * 获取锁的等待时间
     */
    private static final int acquireTimeout  = 1 * 10000;

    static {
        RELEASE_LUA = new StringBuilder()
                .append("if redis.call('get', KEYS[1]) == ARGV[1] ")
                .append("then ")
                .append(" return redis.call('del', KEYS[1]) ")
                .append("else ")
                .append(" return 0")
                .append(" end").toString();
    }

    @Autowired
    JedisPool jedisPool;

    @Override
    public java.lang.String acquire(String key, long expireTime) {
        // 锁的超时时间
        long end = System.currentTimeMillis() + acquireTimeout;
        // 随机生成一个value
        String requireToken = UUID.randomUUID().toString();
        Jedis jedis = jedisPool.getResource();
        try {
            while (System.currentTimeMillis() < end) {
                SetParams params = SetParams.setParams().nx().px(expireTime);
                String result = jedis.set(key, requireToken, params);
                if(LOCK_SUCCESS.equals(result)){
                    return requireToken;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error("acquire lock due to error", e);
                }
            }
        } finally {
            if(null != jedis){
                jedis.close();
            }
        }

        return null;
    }

    @Override
    public boolean release(String key, String indentifier) {
        Jedis jedis = jedisPool.getResource();
        try {
            Object result = jedis.eval(RELEASE_LUA, Collections.singletonList(key),
                    Collections.singletonList(indentifier));
            if(RELEASE_SUCCESS.equals(result.toString())){
                return true;
            }
            return false;
        }finally {
            if(null != jedis){
                jedis.close();
            }
        }
    }
}
