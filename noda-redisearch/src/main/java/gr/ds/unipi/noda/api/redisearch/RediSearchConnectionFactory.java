package gr.ds.unipi.noda.api.redisearch;

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
import gr.ds.unipi.noda.api.redisearch.aggregateOperators.RediSearchAggregateOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators.RediSearchComparisonOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators.RediSearchGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoTextualOperators.RediSearchGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.logicalOperators.RediSearchLogicalOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators.RediSearchTextualOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.sortOperators.RedisSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class RediSearchConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return RediSearchOperators.newRedisOperators(connector, s, sparkSession);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        RediSearchConnectionManager.getInstance().closeConnection(noSqlDbConnector);
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
    protected BaseGeoSpatialOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new RediSearchGeoSpatialOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return null;
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new RediSearchGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new RediSearchLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new RedisSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new RediSearchTextualOperatorFactory();
    }
}
