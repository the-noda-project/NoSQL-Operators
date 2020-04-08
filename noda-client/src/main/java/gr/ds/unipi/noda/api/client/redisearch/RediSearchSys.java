package gr.ds.unipi.noda.api.client.redisearch;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnector;
import javafx.util.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RediSearchSys extends NoSqlDbSys {

    private final RediSearchConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder> {
        private final JedisPoolConfig poolConfig;
        private List<Pair<String, Integer>> sentinels = new ArrayList<>();

        private int connectionTimeout = 2000;
        private int soTimeout = 2000;
        private String password = null;
        private int database = 0;
        private String clientName = null;
        private boolean ssl = false;
        private SSLSocketFactory sslSocketFactory = null;
        private SSLParameters sslParameters = null;
        private HostnameVerifier hostnameVerifier = null;

        private int poolSize;


        public Builder() {
            this.poolConfig = initPoolConfig(8);
        }

        public Builder(int poolSize) {
            this.poolConfig = initPoolConfig(poolSize);
        }

        public Builder(JedisPoolConfig poolConfig) {
            this.poolConfig = poolConfig;
        }

        public Builder timeout(int timeout){
            this.connectionTimeout = timeout;
            this.soTimeout = timeout;
            return this;
        }

        public Builder connectionTimeout(int connectionTimeout){
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder soTimeout(int soTimeout){
            this.soTimeout = soTimeout;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder database(int database){
            this.database = database;
            return this;
        }

        public Builder clientName(String clientName){
            this.clientName = clientName;
            return this;
        }

        public Builder ssl(boolean ssl){
            this.ssl = ssl;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sslSocketFactory){
            this.sslSocketFactory = sslSocketFactory;
            return this;
        }

        public Builder sslParameters(SSLParameters sslParameters){
            this.sslParameters = sslParameters;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier){
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder sentinelHost(String host) {

            int i = 0;
            while (i < sentinels.size()) {
                if (sentinels.get(i).getKey() == null) {
                    sentinels.set(i, new Pair<>(host, sentinels.get(i).getValue()));
                    break;
                }
                i++;
            }
            if (i == sentinels.size()) {
                sentinels.add(new Pair<>(host, null));
            }

            return this;
        }

        public Builder sentinelPort(int port) {

            int i = 0;
            while (i < sentinels.size()) {
                if (sentinels.get(i).getValue() == null) {
                    sentinels.set(i, new Pair<>(sentinels.get(i).getKey(), port));
                    break;
                }
                i++;
            }
            if (i == sentinels.size()) {
                sentinels.add(new Pair<>(null, port));
            }
            return this;
        }

        @Override
        public NoSqlDbSys build() {
            return new RediSearchSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private RediSearchSys(Builder builder) {
        super(builder, new RediSearchConnectionFactory());

        for (int i = 0; i < builder.sentinels.size(); i++) {
            if (builder.sentinels.get(i).getKey() == null) {
                builder.sentinels.set(i, new Pair<>("localhost", builder.sentinels.get(i).getValue()));
            }
            if (builder.sentinels.get(i).getValue() == null) {
                builder.sentinels.set(i, new Pair<>(builder.sentinels.get(i).getKey(), 8001));
            }
        }

        List<Pair<String, Integer>> sentinels = Collections.unmodifiableList(builder.sentinels.stream().distinct().collect(Collectors.toList()));

        if(sentinels.isEmpty()){
            builder.ssl = false;
            builder.sslSocketFactory = null;
            builder.sslParameters = null;
            builder.hostnameVerifier = null;
        }

        if(getAddresses().size()>1){
            try {
                throw new Exception("Up to one master has been defined. One master should be defined");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        connector = RediSearchConnector.newRediSearchConnector(getAddresses().get(0), sentinels, builder.poolConfig, builder.connectionTimeout, builder.soTimeout,builder.password,builder.database,builder.clientName,builder.ssl,builder.sslSocketFactory,builder.sslParameters,builder.hostnameVerifier);
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
