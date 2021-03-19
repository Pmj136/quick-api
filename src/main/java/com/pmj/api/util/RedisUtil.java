package com.pmj.api.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author 彭明久
 * @since 2021-03-19
 */
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    public static void init(RedisTemplate<String, Object> rt) {
        RedisUtil.redisTemplate = rt;
    }

    public static void set(String key, Object data) {
        redisTemplate.opsForValue().set(key, data);
    }

    public static void set(String key, Object data, long expire) {
        redisTemplate.opsForValue().set(key, data, expire, TimeUnit.SECONDS);
    }


    public static Object get(String key) {
        if (key == null) return null;
        return redisTemplate.opsForValue().get(key);
    }

    public static Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    public static Boolean hasKey(String key) {
        if (key == null) return false;
        return redisTemplate.hasKey(key);
    }

    public static Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public static Boolean isExpire(String key) {
        return RedisUtil.getExpire(key) == -2;
    }
}
