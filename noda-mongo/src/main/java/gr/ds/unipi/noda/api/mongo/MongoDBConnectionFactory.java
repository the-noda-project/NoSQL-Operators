package gr.ds.unipi.noda.api.mongo;

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
import gr.ds.unipi.noda.api.mongo.aggregateOperators.MongoDBAggregateOperatorFactory;
import gr.ds.unipi.noda.api.mongo.dataframe.visualization.MongoDBDataframeManipulator;
import gr.ds.unipi.noda.api.mongo.filterOperators.comparisonOperators.MongoDBComparisonOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTemporalOperators.MongoDBGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.MongoDBGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.logicalOperators.MongoDBLogicalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.MongoDBTextualOperatorFactory;
import gr.ds.unipi.noda.api.mongo.joinOperators.MongoDBJoinOperatorFactory;
import gr.ds.unipi.noda.api.mongo.sortOperators.MongoDBSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class MongoDBConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return MongoDBOperators.newMongoDBOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbInserts noSqlDbInserts(NoSqlDbConnector connector, String s) {
        return MongoDbInserts.newMongoDbInserts(connector, s);
    }

    @Override
    public NoSqlDbUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s) {
        return MongoDbUpdates.newMongoUpdates(connector, s);
    }

    @Override
    public NoSqlDbDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s) {
        return MongoDbDeletes.newMongoDeletes(connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        MongoDBConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public boolean closeConnections() {
        return MongoDBConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new MongoDBAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new MongoDBComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new MongoDBGeographicalOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new MongoDBGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new MongoDBGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new MongoDBLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new MongoDBSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new MongoDBTextualOperatorFactory();
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
        return new MongoDBDataframeManipulator();
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return new MongoDBJoinOperatorFactory();
    }

}