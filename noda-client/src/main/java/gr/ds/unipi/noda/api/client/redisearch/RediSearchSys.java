package gr.ds.unipi.noda.api.client.redisearch;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnector;
import javafx.util.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

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
        private Pool<Jedis> jedisPool;
        private JedisPoolConfig poolConfig;
        private List<Pair<String, Integer>> sentinels = new ArrayList<>();
        private int timeout;
        private int poolSize;
        private String password;
        private String masterName;


        public Builder() {
        }

        public Builder(Pool<Jedis> jedisPool) {
            this.jedisPool = jedisPool;
        }

        public Builder(JedisPoolConfig poolConfig) {
            this.poolConfig = poolConfig;
        }

        public Builder options(int timeout, int poolSize, String password) {
            this.timeout = timeout;
            this.poolSize = poolSize;
            this.password = password;
            return this;
        }

        public Builder masterName(String masterName) {
            this.masterName = masterName;
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
        connector = RediSearchConnector.newRediSearchConnector(getAddresses(), sentinels, builder.jedisPool, builder.poolConfig,
                builder.timeout, builder.poolSize, builder.password, builder.masterName);
    }
}
