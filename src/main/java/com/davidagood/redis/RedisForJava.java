package com.davidagood.redis;

import java.util.Map;

public interface RedisForJava {
    String getHashField(String key, String field);

    Map<String, String> getHashFields(String key);

    CommandResult setHashField(String key, String field, String value);

    CommandResult deleteHashField(String key, String field);
}
