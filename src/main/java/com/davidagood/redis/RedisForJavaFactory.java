package com.davidagood.redis;

public class RedisForJavaFactory {
    private RedisForJavaFactory() {
    }

    public static RedisForJava newRedisClient(Redis redis) {
        return new RedisForJavaImpl(redis);
    }

}
