package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public final class RedisConnector implements NoSqlDbConnector<Map<String, Pipeline>> {
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

    private JedisCluster jedisCluster;
    private Map <String, JedisPool> nodeMap;


    public RedisConnector(List<Map.Entry<String, Integer>> addresses, String masterName, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
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
        RedisConnector that = (RedisConnector) o;
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
    public Map<String, Pipeline> createConnection() {
        if (masterName == null){

            Map<String, Pipeline> pipelinesOfNodes = new HashMap<>();

            this.jedisCluster = new JedisCluster(new HostAndPort(addresses.get(0).getKey(), addresses.get(0).getValue()),0);
            nodeMap = jedisCluster.getClusterNodes();

            String anyHost = nodeMap.keySet().iterator().next();

            // getSlotHostMap method has below

            getSlotHostMap(anyHost).forEach(entry->
                    pipelinesOfNodes.put("{"+crc16Slot.get(entry.getKey().intValue()+1)+"}",nodeMap.get(entry.getValue()).getResource().pipelined())
            );

            return pipelinesOfNodes;
        }
        return null;
    }

    public void closeJedisPools(){
        nodeMap.forEach((s,j)-> j.close());
    }

    public void closeJedisCluster(){
        jedisCluster.close();
    }

    public static RedisConnector newRedisConnector(List<Map.Entry<String, Integer>> addresses, String masterName, JedisPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        return new RedisConnector(addresses, masterName, poolConfig, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    private Set<String> getSentinels() {
        return addresses.stream().map(pair -> String.join(StringPool.COLON, pair.getKey(), pair.getValue().toString())).collect(Collectors.toSet());
    }

    private static List<Map.Entry<Long, String>> getSlotHostMap (String anyHostAndPortStr) {
        List<Map.Entry<Long, String>> entries = new ArrayList<>();
        String parts [] = anyHostAndPortStr.split (":");
        HostAndPort anyHostAndPort = new HostAndPort(parts [0], Integer.parseInt (parts [1]));
        try {
            Jedis jedis = new Jedis (anyHostAndPort.getHost (), anyHostAndPort.getPort ());
            List <Object> list = jedis.clusterSlots ();
            for (Object object: list) {
                List <Object> list1 = (List <Object>) object;
                List <Object> master = (List <Object>) list1.get (2);
                String hostAndPort = new String ((byte []) master.get (0)) + ":" + master.get (1);
                entries.add(new AbstractMap.SimpleImmutableEntry<>((Long) list1.get (0), hostAndPort));
            }
            jedis.close ();
        } catch (Exception e) {

        }
        return entries;
    }

    private static List<String> crc16Slot = new BufferedReader(new InputStreamReader(RedisConnector.class.getResourceAsStream("/codes.txt"))).lines().collect(Collectors.toList());

}
