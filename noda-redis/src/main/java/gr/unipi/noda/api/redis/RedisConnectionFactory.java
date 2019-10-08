package gr.unipi.noda.api.redis;

import gr.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.unipi.noda.api.redis.aggregateOperator.RedisAggregateOperatorFactory;
import io.redisearch.aggregation.reducers.Reducer;
import org.apache.spark.sql.SparkSession;

public final class RedisConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return RedisDBConnector.newRedisDBConnector(host, port, username, password, database);
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return RedisDBOperators.newRedisDBOperators((RedisDBConnector) connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        RedisConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public int getDefaultPort() {
        return 6379;
    }

    @Override
    public String getDefaultDatabase() {
        return "";
    }

    @Override
    public String getDefaultUsername() {
        return "";
    }

    @Override
    public String getDefaultPassword() {
        return "";
    }

    @Override
    public boolean closeConnections() {
        return RedisConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getAggregateOperatorFactory() {
        return new RedisAggregateOperatorFactory();
    }
}
