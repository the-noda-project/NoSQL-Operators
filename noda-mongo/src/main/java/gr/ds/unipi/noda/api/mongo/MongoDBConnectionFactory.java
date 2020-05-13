package gr.ds.unipi.noda.api.mongo;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.mongo.aggregateOperators.MongoDBAggregateOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.comparisonOperators.MongoDBComparisonOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTemporalOperators.MongoDBGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.MongoDBGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.logicalOperators.MongoDBLogicalOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.MongoDBTextualOperatorFactory;
import gr.ds.unipi.noda.api.mongo.sortOperators.MongoDBSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class MongoDBConnectionFactory extends NoSqlConnectionFactory {

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return MongoDBOperators.newMongoDBOperators(connector, s, sparkSession);
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

}