package gr.ds.unipi.noda.api.client.redisearch;

import redis.clients.jedis.JedisPoolConfig;

public class RediSearchBuilderFactory {
    public RediSearchSystem.Builder Builder() {
        return new RediSearchSystem.Builder();
    }

    public RediSearchSystem.Builder Builder(int poolSize) {
        return new RediSearchSystem.Builder(poolSize);
    }

    public RediSearchSystem.Builder Builder(JedisPoolConfig poolConfig) {
        return new RediSearchSystem.Builder(poolConfig);
    }

    public RediSearchSystemSentinels.Builder Builder(String masterName) {
        return new RediSearchSystemSentinels.Builder(masterName);
    }

    public RediSearchSystemSentinels.Builder Builder(String masterName, int poolSize) {
        return new RediSearchSystemSentinels.Builder(masterName, poolSize);
    }

    public RediSearchSystemSentinels.Builder Builder(String masterName, JedisPoolConfig poolConfig) {
        return new RediSearchSystemSentinels.Builder(masterName, poolConfig);
    }

}
