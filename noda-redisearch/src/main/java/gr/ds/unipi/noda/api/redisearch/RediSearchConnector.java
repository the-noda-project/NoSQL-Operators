package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import javafx.util.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.util.Pool;

import java.util.List;
import java.util.Objects;

public final class RediSearchConnector implements NoSqlDbConnector<Pool<Jedis>> {
    private final List<Pair<String,Integer>> addresses;
    private final RediSearchOptions rediSearchOptions;
    private final Pool<Jedis> jedisPool;

    private RediSearchConnector(List<Pair<String,Integer>> addresses, RediSearchOptions rediSearchOptions, Pool<Jedis> jedisPool) {
        this.addresses = addresses;
        this.rediSearchOptions = rediSearchOptions;
        this.jedisPool = jedisPool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RediSearchConnector that = (RediSearchConnector) o;
        return (addresses.containsAll(that.addresses) && addresses.size()==that.addresses.size()) &&
                rediSearchOptions.equals(that.rediSearchOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, rediSearchOptions);
    }

    @Override
    public Pool<Jedis> createConnection() {
        if (Objects.isNull(jedisPool)) {
            if(!Objects.isNull(rediSearchOptions)) {
                return getJedisPool();
            } else return new JedisPool(initPoolConfig(100), getHost(), getPort(), 500, null);
        } else return this.jedisPool;
    }

    private Pool<Jedis> getJedisPool() {
        if (rediSearchOptions.isWithSentinels())
            return new JedisSentinelPool(rediSearchOptions.getMaster(), rediSearchOptions.getSentinels(),
                    initPoolConfig(rediSearchOptions.getPoolSize()), rediSearchOptions.getTimeout(), rediSearchOptions.getPassword());
        else
            return new JedisPool(initPoolConfig(rediSearchOptions.getPoolSize()), getHost(), getPort(),
                    rediSearchOptions.getTimeout(), rediSearchOptions.getPassword());
    }

    public static RediSearchConnector newRediSearchConnector(List<Pair<String,Integer>> addresses, RediSearchOptions rediSearchOptions, Pool<Jedis> jedisPool) {
        return new RediSearchConnector(addresses, rediSearchOptions, jedisPool);
    }

    private static JedisPoolConfig initPoolConfig(int poolSize) {
        JedisPoolConfig conf = new JedisPoolConfig();
        conf.setMaxTotal(poolSize);
        conf.setTestOnBorrow(false);
        conf.setTestOnReturn(false);
        conf.setTestOnCreate(false);
        conf.setTestWhileIdle(false);
        conf.setMinEvictableIdleTimeMillis(60000L);
        conf.setTimeBetweenEvictionRunsMillis(30000L);
        conf.setNumTestsPerEvictionRun(-1);
        conf.setFairness(true);
        return conf;
    }

    public int getPort() {
        return addresses.get(0).getValue();
    }


    public String getHost() {
        return addresses.get(0).getKey();
    }
}
