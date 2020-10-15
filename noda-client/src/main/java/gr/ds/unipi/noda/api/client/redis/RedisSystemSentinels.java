package gr.ds.unipi.noda.api.client.redis;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redis.RedisConnectionFactory;
import gr.ds.unipi.noda.api.redis.RedisConnector;
import redis.clients.jedis.JedisPoolConfig;

public class RedisSystemSentinels extends NoSqlDbSystem {

    private final RedisConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 26379;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {
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
            this.poolConfig = RedisSystem.initPoolConfig(8);
        }

        public Builder(String masterName, int poolSize) {
            this.masterName = masterName;
            this.poolConfig = RedisSystem.initPoolConfig(poolSize);
        }

        public Builder(String masterName, JedisPoolConfig poolConfig) {
            this.masterName = masterName;
            this.poolConfig = poolConfig;
        }

        public Builder timeout(int timeout) {
            this.connectionTimeout = timeout;
            this.soTimeout = timeout;
            return this;
        }

        public Builder connectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder soTimeout(int soTimeout) {
            this.soTimeout = soTimeout;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder database(int database) {
            this.database = database;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        @Override
        public NoSqlDbSystem build() {
            return new RedisSystemSentinels(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private RedisSystemSentinels(Builder builder) {
        super(builder, new RedisConnectionFactory());
        connector = RedisConnector.newRedisConnector(getAddresses(), builder.masterName, builder.poolConfig, builder.connectionTimeout, builder.soTimeout, builder.password, builder.database, builder.clientName, false, null, null, null);
    }

}
