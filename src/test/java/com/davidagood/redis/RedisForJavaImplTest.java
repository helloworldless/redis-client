package com.davidagood.redis;

import org.junit.Test;
import org.rarefiedredis.redis.RedisMock;

import java.util.HashMap;
import java.util.Map;

import static com.davidagood.redis.RedisForJavaImpl.STATUS_SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    }

    @Test
    public void isSuccessful() {
        assertFalse(redis.isSuccessful(null));
        assertFalse(redis.isSuccessful(1L));
        assertTrue(redis.isSuccessful(STATUS_SUCCESS));
    }

}