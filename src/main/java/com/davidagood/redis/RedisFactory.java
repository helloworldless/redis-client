package com.davidagood.redis;

public class RedisFactory {
    private RedisFactory() {
    }

    public static Redis newRedisClient() {
        return new RedisImpl();
    }
}
