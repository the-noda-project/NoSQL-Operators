package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.redis.aggregateOperator.HBaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators.HBaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperators.geoSpatialOperators.HBaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperators.geoTemporalOperators.HBaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperators.geoTextualOperators.HBaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.logicalOperators.HBaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperator.textualOperators.HBaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.redis.sortOperator.HBaseSortOperatorFactory;
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

public final class HBaseConnectionFactory extends NoSqlConnectionFactory {
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
        return new HBaseAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new HBaseComparisonOperatorFactory();
    }

    @Override
    protected BaseGeoSpatialOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new HBaseGeoSpatialOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new HBaseGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new HBaseGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new HBaseLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new HBaseSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new HBaseTextualOperatorFactory();
    }
}