package com.davidagood.redis;

import java.util.Map;

class RedisForJavaImpl implements RedisForJava {

    static final Long STATUS_SUCCESS = 0L;

    private final Redis redis;

    RedisForJavaImpl(Redis redis) {
        this.redis = redis;
    }

    public String getHashField(String key, String field) {
        return redis.hget(key, field);
    }

    public Map<String, String> getHashFields(String key) {
        return redis.hgetAll(key);
    }

    public boolean setHashField(String key, String field, String value) {
        return isSuccessful(redis.hset(key, field, value));
    }

    boolean isSuccessful(Long status) {
        return STATUS_SUCCESS.equals(status);
    }

}