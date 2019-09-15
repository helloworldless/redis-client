package com.davidagood.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisWrapper implements Redis {
    private final Jedis jedis;

    public JedisWrapper(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    @Override
    public Long hdel(String key, String field) {
        return jedis.hdel(key, field);
    }

}
