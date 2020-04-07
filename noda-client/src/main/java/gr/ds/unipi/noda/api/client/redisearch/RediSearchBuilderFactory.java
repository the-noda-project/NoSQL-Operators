package gr.ds.unipi.noda.api.client.redisearch;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

public class RediSearchBuilderFactory {
    public RediSearchSys.Builder Builder() {
        return new RediSearchSys.Builder();
    }

    public RediSearchSys.Builder Builder(Pool<Jedis> jedisPool) {
        return new RediSearchSys.Builder(jedisPool);
    }

    public RediSearchSys.Builder Builder(JedisPoolConfig poolConfig) {
        return new RediSearchSys.Builder(poolConfig);
    }
}
