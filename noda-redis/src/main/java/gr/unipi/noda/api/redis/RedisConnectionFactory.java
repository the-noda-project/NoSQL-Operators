package gr.unipi.noda.api.redis;

import gr.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.unipi.noda.api.redis.aggregateOperator.RedisAggregateOperatorFactory;
import gr.unipi.noda.api.redis.filterOperator.comparisonOperator.RedisComparisonOperatorFactory;
import gr.unipi.noda.api.redis.filterOperator.logicalOperator.RedisLogicalOperatorFactory;
import gr.unipi.noda.api.redis.sortOperator.RedisSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public class RedisConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return RedisConnector.newRedisConnector(host, port, username, password, database);
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return RedisOperators.newRedisOperators((RedisConnector) connector, s);
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
        return null;
    }

    @Override
    public boolean closeConnections() {
        return RedisConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new RedisAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new RedisComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeographicalOperatorFactory() {
        return null;
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new RedisLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new RedisSortOperatorFactory();
    }
}
