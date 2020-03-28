package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.hbase.aggregateOperator.RedisAggregateOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.comparisonOperators.RedisComparisonOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.RedisGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoTemporalOperators.RedisGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoTextualOperators.RedisGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.logicalOperators.RedisLogicalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators.RedisTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.sortOperator.RedisSortOperatorFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class RedisConnectionFactory extends NoSqlConnectionFactory {
    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return null;
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return null;
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {

    }

    @Override
    public int getDefaultPort() {
        return 0;
    }

    @Override
    public String getDefaultDatabase() {
        return null;
    }

    @Override
    public String getDefaultUsername() {
        return null;
    }

    @Override
    public String getDefaultPassword() {
        return null;
    }

    @Override
    public boolean closeConnections() {
        return false;
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
    protected BaseGeoSpatialOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new RedisGeoSpatialOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new RedisGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new RedisGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new RedisLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new RedisSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new RedisTextualOperatorFactory();
    }
}
