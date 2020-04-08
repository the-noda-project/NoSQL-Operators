package gr.ds.unipi.noda.api.client.redisearch;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

public class RediSearchBuilderFactory {
    public RediSearchSys.Builder Builder() {
        return new RediSearchSys.Builder();
    }

    public RediSearchSys.Builder Builder(int poolSize) {
        return new RediSearchSys.Builder(poolSize);
    }

    public RediSearchSys.Builder Builder(JedisPoolConfig poolConfig) {
        return new RediSearchSys.Builder(poolConfig);
    }

    public RediSearchSysSentinels.Builder Builder(String masterName) {
        return new RediSearchSysSentinels.Builder(masterName);
    }

    public RediSearchSysSentinels.Builder Builder(String masterName, int poolSize) {
        return new RediSearchSysSentinels.Builder(masterName, poolSize);
    }

    public RediSearchSysSentinels.Builder Builder(String masterName, JedisPoolConfig poolConfig) {
        return new RediSearchSysSentinels.Builder(masterName, poolConfig);
    }

}
