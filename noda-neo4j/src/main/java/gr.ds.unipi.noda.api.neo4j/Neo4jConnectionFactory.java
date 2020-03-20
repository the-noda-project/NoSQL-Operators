package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.neo4j.aggregateOperator.Neo4jAggregateOperatorFactory;
import gr.ds.unipi.noda.api.neo4j.filterOperator.comparisonOperator.Neo4jComparisonOperatorFactory;
import gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator.Neo4JGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.neo4j.filterOperator.logicalOperator.Neo4jLogicalOperatorFactory;
import gr.ds.unipi.noda.api.neo4j.sortOperator.Neo4jSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class Neo4jConnectionFactory extends NoSqlConnectionFactory {
    @Override
    public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
        return Neo4jConnector.newNeo4jConnector(host, port, username, password, database);
    }

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return Neo4jOperators.newNeo4jOperators((Neo4jConnector) connector, s, sparkSession);
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
        Neo4jConnectionManager.getInstance().closeConnection(noSqlDbConnector);
    }

    @Override
    public int getDefaultPort() {
        return 7687;
    }

    @Override
    public String getDefaultDatabase() {
        return "";
    }

    @Override
    public String getDefaultUsername() {
        return "neo4j";
    }

    @Override
    public String getDefaultPassword() {
        return "neo4j";
    }

    @Override
    public boolean closeConnections() {
        return Neo4jConnectionManager.getInstance().closeConnections();
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new Neo4jAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new Neo4jComparisonOperatorFactory();
    }

    @Override
    protected BaseGeoSpatialOperatorFactory getBaseGeographicalOperatorFactory() {
        return new Neo4JGeoSpatialOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new Neo4jLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new Neo4jSortOperatorFactory();
    }

}