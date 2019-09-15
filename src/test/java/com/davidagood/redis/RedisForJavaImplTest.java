package com.davidagood.redis;

import org.junit.Test;
import org.rarefiedredis.redis.RedisMock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RedisForJavaImplTest {

    private final RedisForJavaImpl redis = new RedisForJavaImpl(new RedisMockWrapper(new RedisMock()));

    @Test
    public void integrationTest() {
        String hashPerson = "person";
        String sally = "Sally";
        String sallycita = "Sallycita";
        String fieldName = "name";
        String fieldNickname = "nickname";

        redis.setHashField(hashPerson, fieldName, sally);
        assertEquals(sally, redis.getHashField(hashPerson, fieldName));

        redis.setHashField(hashPerson, fieldNickname, sallycita);
        Map<String, String> personFields = redis.getHashFields(hashPerson);

        Map<String, String> expectedPersonFields = new HashMap<>();
        expectedPersonFields.put(fieldName, sally);
        expectedPersonFields.put(fieldNickname, sallycita);
        assertEquals(expectedPersonFields, personFields);

        redis.deleteHashField(hashPerson, fieldNickname);
        expectedPersonFields.remove(fieldNickname);
        assertEquals(expectedPersonFields, redis.getHashFields(hashPerson));
    }

}