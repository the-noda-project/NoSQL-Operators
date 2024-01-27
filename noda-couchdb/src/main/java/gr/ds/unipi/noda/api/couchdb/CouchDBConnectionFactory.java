package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.dataframe.visualization.BaseDataframeManipulator;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
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
import gr.ds.unipi.noda.api.couchdb.aggregateOperators.CouchDBAggregateOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators.CouchDBComparisonOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTemporalOperators.CouchDBGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.CouchDBGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators.CouchDBGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.logicalOperators.CouchDBLogicalOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.CouchDBTextualOperatorFactory;
import gr.ds.unipi.noda.api.couchdb.sortOperators.CouchDBSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class CouchDBConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public CouchDBOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return CouchDBOperators.newCouchDBOperators((CouchDBConnector) connector, s, sparkSession);
    }

    @Override
    public CouchDBInserts noSqlDbInserts(NoSqlDbConnector connector, String s) {
        return CouchDBInserts.newCouchDbInserts((CouchDBConnector) connector, s);
    }

    @Override
    public CouchDBUpdates noSqlDbUpdates(NoSqlDbConnector connector, String s) {
        return CouchDBUpdates.newCouchDbUpdates((CouchDBConnector) connector, s);
    }

    @Override
    public CouchDBDeletes noSqlDbDeletes(NoSqlDbConnector connector, String s) {
        return CouchDBDeletes.newCouchDbDeletes((CouchDBConnector) connector, s);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        CouchDBConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public boolean closeConnections() {
        return CouchDBConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new CouchDBAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new CouchDBComparisonOperatorFactory();
    }

    @Override
    protected BaseGeographicalOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new CouchDBGeographicalOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new CouchDBGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new CouchDBGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new CouchDBLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new CouchDBSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new CouchDBTextualOperatorFactory();
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
