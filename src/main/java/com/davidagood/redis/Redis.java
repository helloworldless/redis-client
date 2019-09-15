package com.davidagood.redis;

import java.util.Map;

public interface Redis {
    String hget(String key, String field);

    Map<String, String> hgetAll(String key);

    Long hset(String key, String field, String value);

    Long hdel(String key, String field);
}
