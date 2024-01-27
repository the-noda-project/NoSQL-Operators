package gr.ds.unipi.noda.api.core.nosqldb;

import gr.ds.unipi.noda.api.core.dataframe.visualization.BaseDataframeManipulator;
import gr.ds.unipi.noda.api.core.dataframe.visualization.DataframeManipulator;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.BaseRoadNetworkOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.RoadNetworkOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.BaseTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.BaseJoinOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.SparkSession;

public abstract class NoSqlConnectionFactory {

    protected NoSqlConnectionFactory() {
        setBaseOperators();
    }

    public abstract NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession);

    public abstract NoSqlDbInserts noSqlDbInserts(NoSqlDbConnector connector, String s);

    public abstract NoSqlDbUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s);

    public abstract NoSqlDbDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s);

    public abstract void closeConnection(NoSqlDbConnector noSqlDbConnector);

    public abstract boolean closeConnections();

    private void setBaseOperators() {
        ComparisonOperator.comparisonOperator = getBaseComparisonOperatorFactory();

        GeographicalOperator.geoSpatialOperator = getBaseGeoSpatialOperatorFactory();
        GeoTemporalOperator.geoTemporalOperator = getBaseGeoTemporalOperatorFactory();
        GeoTextualOperator.geoTextualOperator = getBaseGeoTextualOperatorFactory();
        LogicalOperator.logicalOperator = getBaseLogicalOperatorFactory();
        AggregateOperator.aggregateOperator = getBaseAggregateOperatorFactory();
        SortOperator.sortOperator = getBaseSortOperatorFactory();
        TextualOperator.textualOperator = getBaseTextualOperatorFactory();
        TrajectoryOperator.trajectoryOperator = getBaseTrajectoryOperatorFactory();
        RoadNetworkOperator.roadNetworkOperator = getBaseRoadNetworkOperatorFactory();

        DataframeManipulator.baseDataframeManipulator = getBaseDataframeManipulator();

        JoinOperator.joinOperator = getBaseJoinOperatorFactory();
    }

    protected abstract BaseAggregateOperatorFactory getBaseAggregateOperatorFactory();

    protected abstract BaseComparisonOperatorFactory getBaseComparisonOperatorFactory();

    protected abstract BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory();

    protected abstract BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory();

    protected abstract BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory();

    protected abstract BaseLogicalOperatorFactory getBaseLogicalOperatorFactory();

    protected abstract BaseSortOperatorFactory getBaseSortOperatorFactory();

    protected abstract BaseTextualOperatorFactory getBaseTextualOperatorFactory();

    protected abstract BaseTrajectoryOperatorFactory getBaseTrajectoryOperatorFactory();

    protected abstract BaseRoadNetworkOperatorFactory getBaseRoadNetworkOperatorFactory();

    protected abstract BaseDataframeManipulator getBaseDataframeManipulator();

    protected abstract BaseJoinOperatorFactory getBaseJoinOperatorFactory();

}
