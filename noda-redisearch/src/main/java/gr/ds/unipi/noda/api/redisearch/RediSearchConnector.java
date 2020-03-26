package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Objects;

public final class RediSearchConnector implements NoSqlDbConnector<JedisPool> {
    private final String host;
    private final int port;
    private final String username;
    private final String password;

    private RediSearchConnector(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RediSearchConnector that = (RediSearchConnector) o;
        return port == that.port &&
                Objects.equals(host, that.host) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, username, password);
    }

    @Override
    public JedisPool createConnection() {
        return new JedisPool(initPoolConfig(100), host, port, 500, password);
    }

    static RediSearchConnector newRedisConnector(String host, int port, String username, String password) {
        return new RediSearchConnector(host, port, username, password);
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
}
