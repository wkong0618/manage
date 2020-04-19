package com.wk.manage.common.redis.enums;

/**
 * 描述:
 * redis缓存key集合
 * 根据业务定义并发key
 * @author wukong
 * @create 2020-03-22 下午6:23
 */
public enum CacheKeysEnum {
    /**
     * 测试
     */
    TEST("test:key");

    private String key;

    CacheKeysEnum(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
