package gr.ds.unipi.noda.api.yyydatabase;

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
import gr.ds.unipi.noda.api.yyydatabase.aggregateOperators.YYYDataBaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.dataframe.visualization.YYYDatabaseDataframeManipulator;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.comparisonOperators.YYYDataBaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.geoTemporalOperators.YYYDataBaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.geoTextualOperators.YYYDataBaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.geographicalOperators.YYYDataBaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.roadNetworkOperators.YYYDataBaseRoadNetworkOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.trajectoryOperators.YYYDataBaseTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.logicalOperators.YYYDataBaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.textualOperators.YYYDataBaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.joinOperators.YYYDataBaseJoinOperatorFactory;
import gr.ds.unipi.noda.api.yyydatabase.sortOperators.YYYDataBaseSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class YYYDataBaseConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return YYYDataBaseOperators.newYYYDataBaseOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbInserts noSqlDbInserts(NoSqlDbConnector connector, String s) {
        return YYYDataBaseInserts.newYYYDataBaseInsert(connector, s);
    }

    @Override
    public NoSqlDbUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s) {
        return YYYDataBaseUpdates.newYYYDataBaseUpdate(connector, s);
    }

    @Override
    public NoSqlDbDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s) {
        return YYYDataBaseDeletes.newYYYDataBaseDelete(connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        YYYDataBaseConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public boolean closeConnections() {
        return YYYDataBaseConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new YYYDataBaseAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new YYYDataBaseComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new YYYDataBaseGeographicalOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new YYYDataBaseGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new YYYDataBaseGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new YYYDataBaseLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new YYYDataBaseSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new YYYDataBaseTextualOperatorFactory();
    }

    @Override
    protected BaseTrajectoryOperatorFactory getBaseTrajectoryOperatorFactory() {
        return new YYYDataBaseTrajectoryOperatorFactory();
    }

    @Override
    protected BaseRoadNetworkOperatorFactory getBaseRoadNetworkOperatorFactory() {
        return new YYYDataBaseRoadNetworkOperatorFactory();
    }

    @Override
    protected BaseDataframeManipulator getBaseDataframeManipulator() {
        return new YYYDatabaseDataframeManipulator();
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return new YYYDataBaseJoinOperatorFactory();
    }
}
