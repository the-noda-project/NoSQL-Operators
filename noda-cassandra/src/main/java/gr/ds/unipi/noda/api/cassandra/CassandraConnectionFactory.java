package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.cassandra.aggregateOperators.CassandraAggregateOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.dataframe.visualization.CassandraDataframeManipulator;
import gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators.CassandraComparisonOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators.CassandraGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.CassandraGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.CassandraGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.filterOperators.logicalOperators.CassandraLogicalOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.filterOperators.textualOperators.CassandraTextualOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.joinOperators.CassandraJoinOperatorFactory;
import gr.ds.unipi.noda.api.cassandra.sortOperators.CassandraSortOperatorFactory;
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
import org.apache.spark.sql.SparkSession;

public final class CassandraConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return CassandraOperators.newCassandraOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbInserts noSqlDbInserts(NoSqlDbConnector connector, String s) {
        return CassandraInserts.newCassandraInsert(connector, s);
    }

    @Override
    public NoSqlDbUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s) {
        return CassandraUpdates.newCassandraUpdate(connector, s);
    }

    @Override
    public NoSqlDbDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s) {
        return CassandraDeletes.newCassandraDelete(connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        CassandraConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public boolean closeConnections() {
        return CassandraConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new CassandraAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new CassandraComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new CassandraGeographicalOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new CassandraGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new CassandraGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new CassandraLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new CassandraSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new CassandraTextualOperatorFactory();
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
        return new CassandraDataframeManipulator();
    }

    @Override
    protected BaseJoinOperatorFactory getBaseJoinOperatorFactory() {
        return new CassandraJoinOperatorFactory();
    }
}
