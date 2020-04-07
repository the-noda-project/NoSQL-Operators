package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import javafx.util.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.util.Pool;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class RediSearchConnector implements NoSqlDbConnector<Pool<Jedis>> {
    private final List<Pair<String, Integer>> masters;
    private final List<Pair<String, Integer>> sentinels;
    private final Pool<Jedis> jedisPool;
    private final JedisPoolConfig poolConfig;
    private final int timeout;
    private final int poolSize;
    private final String password;
    private final String masterName;

    private RediSearchConnector(List<Pair<String, Integer>> masters, List<Pair<String, Integer>> sentinels, Pool<Jedis> jedisPool,
                                JedisPoolConfig poolConfig, int timeout, int poolSize, String password, String masterName) {
        this.masters = masters;
        this.sentinels = sentinels;
        this.jedisPool = jedisPool;
        this.poolConfig = poolConfig;
        this.timeout = timeout;
        this.poolSize = poolSize;
        this.password = password;
        this.masterName = masterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RediSearchConnector that = (RediSearchConnector) o;
        return (masters.containsAll(that.masters) && masters.size() == that.masters.size()) &&
                sentinels.containsAll(that.sentinels) && sentinels.size() == that.sentinels.size() &&
                jedisPool.equals(that.jedisPool) && poolConfig.equals(that.poolConfig) &&
                password.equals(that.password) && masterName.equals(that.masterName) &&
                timeout == that.timeout && poolSize == that.poolSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(masters, sentinels, jedisPool, poolConfig, timeout, poolSize, password, masterName);
    }

    @Override
    public Pool<Jedis> createConnection() {
        if (Objects.isNull(jedisPool)) {
            return getJedisPool();
        } else return this.jedisPool;
    }

    private Pool<Jedis> getJedisPool() {
        if (sentinels.isEmpty())
            return new JedisPool(getPoolConfig(), getHost(), getPort(), getTimeout(), password);
        else
            return new JedisSentinelPool(masterName, getSentinels(), getPoolConfig(), getTimeout(), password);
    }

    public static RediSearchConnector newRediSearchConnector(List<Pair<String, Integer>> masters, List<Pair<String, Integer>> sentinels, Pool<Jedis> jedisPool,
                                                             JedisPoolConfig poolConfig, int timeout, int poolSize, String password, String masterName) {
        return new RediSearchConnector(masters, sentinels, jedisPool, poolConfig, timeout, poolSize, password, masterName);
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

    private int getPort() {
        return masters.get(0).getValue();
    }

    private String getHost() {
        return masters.get(0).getKey();
    }

    private Set<String> getSentinels() {
        return sentinels.stream().map(pair -> String.join(StringPool.COLON, pair.getKey(), pair.getValue().toString())).collect(Collectors.toSet());
    }

    private int getTimeout() {
        return timeout != 0 ? timeout : 500;
    }

    private int getPoolSize() {
        return poolSize != 0 ? poolSize : 100;
    }

    private JedisPoolConfig getPoolConfig() {
        return poolConfig != null ? poolConfig : initPoolConfig(getPoolSize());
    }
}
