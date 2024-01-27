package gr.ds.unipi.noda.api.redis;

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
import gr.ds.unipi.noda.api.redis.aggregateOperators.RedisAggregateOperatorFactory;
import gr.ds.unipi.noda.api.redis.dataframe.visualization.RedisDataframeManipulator;
import gr.ds.unipi.noda.api.redis.filterOperators.comparisonOperators.RedisComparisonOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geoTemporalOperators.RedisGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geoTextualOperators.RedisGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geographicalOperators.RedisGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperators.logicalOperators.RedisLogicalOperatorFactory;
import gr.ds.unipi.noda.api.redis.filterOperators.textualOperators.RedisTextualOperatorFactory;
import gr.ds.unipi.noda.api.redis.sortOperators.RedisSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

public final class RedisConnectionFactory extends NoSqlConnectionFactory {

    public static final List<Long> times = new ArrayList<>();

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return RedisOperators.newRedisOperators(connector, s, sparkSession);
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
        RedisConnectionManager.getInstance().closeConnection(noSqlDbConnector);
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
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new RedisGeographicalOperatorFactory();
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
        return new RedisDataframeManipulator();
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return null;
    }
}
