package gr.ds.unipi.noda.api.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.util.Pool;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class RedisSingleInstanceConnector extends RedisConnector {
    private final List<Map.Entry<String, Integer>> addresses;
    private final JedisPoolConfig poolConfig;
    private final int connectionTimeout;
    private final int soTimeout;
    private final String password;
    private final int database;
    private final String clientName;
    private final boolean ssl;
    private final SSLSocketFactory sslSocketFactory;
    private final SSLParameters sslParameters;
    private final HostnameVerifier hostnameVerifier;

    private Pool<Jedis> pool;

    public RedisSingleInstanceConnector(List<Map.Entry<String, Integer>> addresses, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.addresses = addresses;
        this.poolConfig = poolConfig;
        this.connectionTimeout = connectionTimeout;
        this.soTimeout = soTimeout;
        this.password = password;
        this.database = database;
        this.clientName = clientName;
        this.ssl = ssl;
        this.sslSocketFactory = sslSocketFactory;
        this.sslParameters = sslParameters;
        this.hostnameVerifier = hostnameVerifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedisSingleInstanceConnector that = (RedisSingleInstanceConnector) o;
        return connectionTimeout == that.connectionTimeout &&
                soTimeout == that.soTimeout &&
                database == that.database &&
                ssl == that.ssl &&
                (addresses.containsAll(that.addresses) && addresses.size()==that.addresses.size()) &&
                Objects.equals(poolConfig, that.poolConfig) &&
                Objects.equals(password, that.password) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(sslSocketFactory, that.sslSocketFactory) &&
                Objects.equals(sslParameters, that.sslParameters) &&
                Objects.equals(hostnameVerifier, that.hostnameVerifier);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for(Map.Entry<String,Integer> e : addresses){
            hashCode = 31*hashCode+(e==null ?0:e.hashCode());
        }
        return 31*hashCode+ Objects.hash(poolConfig, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    @Override
    public Map<String, Pipeline> createConnection() {
        Map<String, Pipeline> pipelinesOfNodes = new HashMap<>();
        pool = new JedisPool(new GenericObjectPoolConfig(), addresses.get(0).getKey(), addresses.get(0).getValue(), 2000, 2000, null, 0, null, false, null, null, null);
        pipelinesOfNodes.put("", pool.getResource().pipelined());
        return pipelinesOfNodes;
    }

    @Override
    public void closeConnection(){
        pool.close();
    }

    public static RedisSingleInstanceConnector newRedisSingleInstanceConnector(List<Map.Entry<String, Integer>> addresses, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        return new RedisSingleInstanceConnector(addresses, poolConfig, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

}
