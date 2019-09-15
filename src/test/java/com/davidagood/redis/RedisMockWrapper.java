package com.davidagood.redis;

import org.rarefiedredis.redis.RedisMock;
import org.rarefiedredis.redis.WrongTypeException;

import java.util.Map;

public class RedisMockWrapper implements Redis {
    private final RedisMock redisMock;

    public RedisMockWrapper(RedisMock redisMock) {
        this.redisMock = redisMock;
    }

    @Override
    public String hget(String key, String field) {
        try {
            return redisMock.hget(key, field);
        } catch (WrongTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        try {
            return redisMock.hgetall(key);
        } catch (WrongTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long hset(String key, String field, String value) {
        try {
            return redisMock.hset(key, field, value) ? 0L : 1L;
        } catch (WrongTypeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long hdel(String key, String field) {
        try {
            return redisMock.hdel(key, field);
        } catch (WrongTypeException e) {
            throw new RuntimeException(e);
        }
    }

}
