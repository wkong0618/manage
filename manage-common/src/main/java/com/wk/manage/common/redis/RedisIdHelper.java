package com.wk.manage.common.redis;

import com.wk.manage.common.util.LocalDateTimeUtil;
import com.wk.manage.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * redis唯一标识生成器
 *
 * @author wukong
 * @create 2020-03-22 下午8:08
 */
@Service
public class RedisIdHelper {
    public static final int EXPIRE_TIME = 25 * 60 * 60;

    @Autowired
    RedisClient redisClient;

    /**
     * 生成唯一流水号
     * @param redisKeyPrefix redisKey前缀(按照不同业务设置不同的key)
     * @param serialNoPrefix 流水号前缀(自定义，可为空)
     * @param serialNoSuffix 流水号后缀(自定义，可为空)
     * @return
     */
    public String generateSerialNo(String redisKeyPrefix, String serialNoPrefix, String serialNoSuffix){
        String nowTime = LocalDateTimeUtil.formatLDTNow(LocalDateTimeUtil.style_yyyyMMdd);
        String key = redisKeyPrefix + nowTime;
        long sequence = getSequence(key);
        String serialNo = new StringBuilder()
                .append(serialNoPrefix)
                .append(LocalDateTimeUtil.formatLDTNow(LocalDateTimeUtil.style_yyyyMMddHHmmssSSS))
                .append(StringUtil.padRight(String.valueOf(sequence), 7, '0'))
                .append(serialNoSuffix).toString();
        return serialNo;
    }

    /**
     * redis key 值递增
     * 首次设置key的过期时间
     * @param key
     * @return
     */
    private long getSequence(String key) {
        long sequence = redisClient.incr(key, 1);

        // 设置 key 过期时间
        if (sequence == 1) {
            redisClient.expire(key, EXPIRE_TIME);
        }
        return sequence;
    }
}
