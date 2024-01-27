package gr.ds.unipi.noda.api.hbase;

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
import gr.ds.unipi.noda.api.hbase.aggregateOperators.HBaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.hbase.dataframe.visualization.HBaseDataframeManipulator;
import gr.ds.unipi.noda.api.hbase.filterOperators.comparisonOperators.HBaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.HBaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTextualOperators.HBaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.HBaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperators.logicalOperators.HBaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperators.textualOperators.HBaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.sortOperators.HBaseSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class HBaseConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return HBaseOperators.newHBaseOperators(connector, s, sparkSession);
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
        HBaseConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public boolean closeConnections() {
        return HBaseConnectionManager.getInstance().closeConnections();
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
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new HBaseGeographicalOperatorFactory();
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
        return new HBaseDataframeManipulator();
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return null;
    }
}
