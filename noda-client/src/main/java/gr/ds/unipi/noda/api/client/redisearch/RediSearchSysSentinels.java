package gr.ds.unipi.noda.api.client.redisearch;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnector;
import javafx.util.Pair;
import redis.clients.jedis.JedisPoolConfig;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RediSearchSysSentinels extends NoSqlDbSys {

    private final RediSearchConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 26379;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder> {
        private final JedisPoolConfig poolConfig;
        private final String masterName;

        private int connectionTimeout = 2000;
        private int soTimeout = 2000;
        private String password = null;
        private int database = 0;
        private String clientName = null;

        private int poolSize;


        public Builder(String masterName) {
            this.masterName = masterName;
            this.poolConfig = RediSearchSys.initPoolConfig(8);
        }

        public Builder(String masterName, int poolSize) {
            this.masterName = masterName;
            this.poolConfig = RediSearchSys.initPoolConfig(poolSize);
        }

        public Builder(String masterName, JedisPoolConfig poolConfig) {
            this.masterName = masterName;
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

        @Override
        public NoSqlDbSys build() {
            return new RediSearchSysSentinels(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private RediSearchSysSentinels(Builder builder) {
        super(builder, new RediSearchConnectionFactory());
        connector = RediSearchConnector.newRediSearchConnector(getAddresses(), builder.masterName, builder.poolConfig, builder.connectionTimeout, builder.soTimeout,builder.password,builder.database,builder.clientName,false,null,null,null);
    }

}
