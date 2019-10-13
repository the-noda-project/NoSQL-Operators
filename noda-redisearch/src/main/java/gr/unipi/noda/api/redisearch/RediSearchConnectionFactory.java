package gr.unipi.noda.api.redisearch;

import gr.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.unipi.noda.api.redisearch.aggregateOperator.RediSearchAggregateOperatorFactory;
import gr.unipi.noda.api.redisearch.filterOperator.comparisonOperator.RediSearchComparisonOperatorFactory;
import gr.unipi.noda.api.redisearch.filterOperator.logicalOperator.RediSearchLogicalOperatorFactory;
import gr.unipi.noda.api.redisearch.sortOperator.RediSearchSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public class RediSearchConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return RediSearchDBConnector.newRedisDBConnector(host, port, username, password, database);
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return RediSearchDBOperators.newRedisDBOperators((RediSearchDBConnector) connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        RediSearchConnectionManager.getInstance().closeConnection(noSqlDbConnector);
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
        return RediSearchConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new RediSearchAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new RediSearchComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeographicalOperatorFactory() {
        return null;
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new RediSearchLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new RediSearchSortOperatorFactory();
    }
}
