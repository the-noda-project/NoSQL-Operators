package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RediSearchConnector implements NoSqlDbConnector<Client> {
    private String indexName;
    private JedisPool jedisPool;

    private RediSearchConnector(String host, int port, String username, String password, String indexName) {
        this.indexName = indexName;
        jedisPool = new JedisPool(initPoolConfig(100), host, port, 500, password);
    }

    @Override
    public Client createConnection() {
        return new Client(indexName, jedisPool);
    }

    static RediSearchConnector newRedisConnector(String host, int port, String username, String password, String database) {
        return new RediSearchConnector(host, port, username, password, database);
    }

    void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    String getIndexName() {
        return this.indexName;
    }

    Jedis getJedisConn() {
        return jedisPool.getResource();
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
