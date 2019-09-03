# Redis Client

## Usage
```
private RedisForJava redis = RedisForJavaFactory.newRedisClient(new JedisWrapper(new Jedis()));
```

## Notes

### Redis Server
Currently only supports using a locally running Redis server with default settings (e.g. no password)

### Supported Operations
Currently these are the only Redis operations that are supported:

Method Name|Redis Operation|Comments
---|---|---
getHashField|HGET|
setHashField|HSET|
getHashFields|HGETALL|

## Build
1. Run `./gradlew clean build`

## Install to Local Maven Repository
1. Run `./gradlew `

### Maven Publish Plugin
1. Run `./gradlew publishMavenJavaPublicationToMavenLocal`
