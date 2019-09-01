package com.davidagood.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

class RedisImpl implements Redis {

    static final Long STATUS_SUCCESS = 0L;

    private Jedis jedis = new Jedis();

    public String getHashField(String key, String field) {
        return jedis.hget(key, field);
    }

    public Map<String, String> getHashFields(String key) {
        return jedis.hgetAll(key);
    }

    public boolean setHashField(String key, String field, String value) {
        return isSuccessful(jedis.hset(key, field, value));
    }

    boolean isSuccessful(Long status) {
        return STATUS_SUCCESS.equals(status);
    }

}