package gr.ds.unipi.noda.api.client.redis;

import redis.clients.jedis.JedisPoolConfig;

public class RedisBuilderFactory {
    public RedisSystem.Builder Builder() {
        return new RedisSystem.Builder();
    }

    public RedisSystem.Builder Builder(int poolSize) {
        return new RedisSystem.Builder(poolSize);
    }

    public RedisSystem.Builder Builder(JedisPoolConfig poolConfig) {
        return new RedisSystem.Builder(poolConfig);
    }

    public RedisSystemSentinels.Builder Builder(String masterName) {
        return new RedisSystemSentinels.Builder(masterName);
    }

    public RedisSystemSentinels.Builder Builder(String masterName, int poolSize) {
        return new RedisSystemSentinels.Builder(masterName, poolSize);
    }

    public RedisSystemSentinels.Builder Builder(String masterName, JedisPoolConfig poolConfig) {
        return new RedisSystemSentinels.Builder(masterName, poolConfig);
    }

}
