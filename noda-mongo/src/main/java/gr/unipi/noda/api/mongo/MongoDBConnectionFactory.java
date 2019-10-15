package gr.unipi.noda.api.mongo;

import gr.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.unipi.noda.api.mongo.aggregateOperator.MongoDBAggregateOperatorFactory;
import gr.unipi.noda.api.mongo.filterOperator.comparisonOperator.MongoDBComparisonOperatorFactory;
import gr.unipi.noda.api.mongo.filterOperator.geographicalOperator.MongoDBGeographicalOperatorFactory;
import gr.unipi.noda.api.mongo.filterOperator.logicalOperator.MongoDBLogicalOperatorFactory;
import gr.unipi.noda.api.mongo.sortOperator.MongoDBSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class MongoDBConnectionFactory extends NoSqlConnectionFactory {
    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return MongoDBConnector.newMongoDBConnector(host, port, username, password, database);
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return MongoDBOperators.newMongoDBOperators((MongoDBConnector) connector, s, sparkSession);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        MongoDBConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public int getDefaultPort() {
        return 27017;
    }

    @Override
    public String getDefaultDatabase() {
        return "";
    }

    @Override
    public String getDefaultUsername() {
        return "";
    }

    @Override
    public String getDefaultPassword() {
        return "";
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
    protected BaseGeographicalOperatorFactory getBaseGeographicalOperatorFactory() {
        return new MongoDBGeographicalOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new MongoDBLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new MongoDBSortOperatorFactory();
    }

}