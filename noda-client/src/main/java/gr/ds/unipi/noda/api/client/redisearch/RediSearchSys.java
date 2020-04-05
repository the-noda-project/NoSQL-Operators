package gr.ds.unipi.noda.api.client.redisearch;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchOptions;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

import java.util.Set;

public class RediSearchSys extends NoSqlDbSys {

    private final RediSearchConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{
        private Pool<Jedis> jedisPool;
        private RediSearchOptions rediSearchOptions;

        public Builder(){
        }

        public Builder options(int timeout, int poolSize, String password){
            this.rediSearchOptions = RediSearchOptions.createCredential(poolSize, timeout, password);
            this.jedisPool = null;
            return this;
        }

        public Builder options(String master, Set<String> sentinels, int timeout, int poolSize, String password) {
            this.rediSearchOptions = RediSearchOptions.createCredential(master, sentinels, poolSize, timeout, password);
            this.jedisPool = null;
            return this;
        }

        public Builder(Pool<Jedis> jedisPool) {
            this.rediSearchOptions = null;
            this.jedisPool = jedisPool;
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
        connector = RediSearchConnector.newRediSearchConnector(getAddresses(), builder.rediSearchOptions, builder.jedisPool);
    }
}
