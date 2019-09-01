package com.davidagood.redis;

import org.junit.Test;
import redis.embedded.RedisServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.davidagood.redis.RedisImpl.STATUS_SUCCESS;
import static org.junit.Assert.*;

public class RedisImplTest {

    private RedisImpl redis = new RedisImpl();

    @Test
    public void integrationTest() throws IOException {
        RedisServer redisServer = new RedisServer(6379);
        redisServer.start();

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

        redisServer.stop();
    }

    @Test
    public void isSuccessful() {
        assertFalse(redis.isSuccessful(null));
        assertFalse(redis.isSuccessful(1L));
        assertTrue(redis.isSuccessful(STATUS_SUCCESS));
    }

}