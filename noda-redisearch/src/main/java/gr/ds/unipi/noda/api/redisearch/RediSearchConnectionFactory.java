package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.dataframe.visualization.BaseDataframeManipulator;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.BaseRoadNetworkOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.BaseTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.joinOperators.BaseJoinOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.aggregateOperators.RediSearchAggregateOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators.RediSearchComparisonOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.RediSearchGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators.RediSearchGeographicalOperatorFactory;
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
    public NoSqlDbInserts noSqlDbInserts(NoSqlDbConnector connector, String s) {
        return null;
    }

    @Override
    public NoSqlDbUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s) {
        return null;
    }

    @Override
    public NoSqlDbDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s) {
        return null;
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
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new RediSearchGeographicalOperatorFactory();
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

    @Override
    protected BaseTrajectoryOperatorFactory getBaseTrajectoryOperatorFactory() {
        return null;
    }

    @Override
    protected BaseRoadNetworkOperatorFactory getBaseRoadNetworkOperatorFactory() {
        return null;
    }

    @Override
    protected BaseDataframeManipulator getBaseDataframeManipulator() {
        return null;
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return null;
    }
}
