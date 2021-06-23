package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.*;
import java.util.*;

public abstract class RedisConnector implements NoSqlDbConnector<Map<String, Pipeline>> {

    public abstract void closeConnection();
}
