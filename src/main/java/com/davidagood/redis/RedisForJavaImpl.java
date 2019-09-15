package com.davidagood.redis;

import java.util.Map;

import static java.util.Objects.nonNull;

class RedisForJavaImpl implements RedisForJava {

    private final Redis redis;

    RedisForJavaImpl(Redis redis) {
        this.redis = redis;
    }

    @Override
    public String getHashField(String key, String field) {
        return redis.hget(key, field);
    }

    @Override
    public Map<String, String> getHashFields(String key) {
        return redis.hgetAll(key);
    }

    @Override
    public CommandResult setHashField(String key, String field, String value) {
        Long resultCode = redis.hset(key, field, value);
        return CommandResult.builder()
                .resultCode(resultCode)
                .resultDescription("Did overwrite existing field on hash")
                .result(nonNull(resultCode) && resultCode == 0L)
                .build();
    }

    @Override
    public CommandResult deleteHashField(String key, String field) {
        Long resultCode = redis.hdel(key, field);
        return CommandResult.builder()
                .resultCode(resultCode)
                .resultDescription("Was field found and deleted")
                .result(nonNull(resultCode) && resultCode == 1L)
                .build();
    }

}