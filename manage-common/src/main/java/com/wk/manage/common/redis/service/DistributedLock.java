package com.wk.manage.common.redis.service;

/**
 * 描述:
 * redis分布式锁
 *
 * @author wukong
 * @create 2020-03-22 下午2:03
 */
public interface DistributedLock {
    /**
     * 获取锁
     * @return 锁标识
     */
    String acquire(String key, long expireTime);

    /**
     * 释放锁
     * @param key
     * @param indentifier
     * @return
     */
    boolean release(String key, String indentifier);
}
