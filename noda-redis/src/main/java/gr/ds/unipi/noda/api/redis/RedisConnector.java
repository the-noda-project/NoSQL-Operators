package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.Pipeline;

import java.util.Map;

public abstract class RedisConnector implements NoSqlDbConnector<Map<String, Pipeline>> {

    public abstract void closeConnection();
}
