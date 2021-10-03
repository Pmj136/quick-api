package com.example.featdemo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    private void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
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
