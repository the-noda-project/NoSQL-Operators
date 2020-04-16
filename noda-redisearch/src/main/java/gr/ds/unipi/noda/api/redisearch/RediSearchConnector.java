package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.javatuples.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.util.Pool;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class RediSearchConnector implements NoSqlDbConnector<Pool<Jedis>> {

    private final List<Map.Entry<String, Integer>> addresses;
    private final String masterName;
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


    public RediSearchConnector(List<Map.Entry<String, Integer>> addresses, String masterName, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.addresses = addresses;
        this.masterName = masterName;
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
        RediSearchConnector that = (RediSearchConnector) o;
        return connectionTimeout == that.connectionTimeout &&
                soTimeout == that.soTimeout &&
                database == that.database &&
                ssl == that.ssl &&
                (addresses.containsAll(that.addresses) && addresses.size()==that.addresses.size()) &&
                Objects.equals(masterName, that.masterName) &&
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
        return 31*hashCode+ Objects.hash(masterName, poolConfig, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    @Override
    public Pool<Jedis> createConnection() {
        if (masterName == null)
            return new JedisPool(poolConfig, addresses.get(0).getKey(), addresses.get(0).getValue(), connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        else
            return new JedisSentinelPool(masterName, getSentinels(), poolConfig, connectionTimeout, soTimeout, password, database, clientName );
    }

    public static RediSearchConnector newRediSearchConnector(List<Map.Entry<String, Integer>> addresses, String masterName, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        return new RediSearchConnector(addresses, masterName, poolConfig, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    private Set<String> getSentinels() {
        return addresses.stream().map(pair -> String.join(StringPool.COLON, pair.getKey(), pair.getValue().toString())).collect(Collectors.toSet());
    }
}
