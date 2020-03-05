package gr.ds.unipi.noda.api.core.nosqldb;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.SparkSession;

public abstract class NoSqlConnectionFactory {

    protected NoSqlConnectionFactory() {
        setBaseOperators();
    }

    public abstract NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession);

    public abstract void closeConnection(NoSqlDbConnector noSqlDbConnector);

    public String getDefaultHost() {
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

    public abstract boolean closeConnections();

    private void setBaseOperators() {
        ComparisonOperator.comparisonOperator = getBaseComparisonOperatorFactory();
        GeographicalOperator.geographicalOperator = getBaseGeographicalOperatorFactory();
        LogicalOperator.logicalOperator = getBaseLogicalOperatorFactory();
        AggregateOperator.aggregateOperator = getBaseAggregateOperatorFactory();
        SortOperator.sortOperator = getBaseSortOperatorFactory();
    }

    protected abstract BaseAggregateOperatorFactory getBaseAggregateOperatorFactory();

    protected abstract BaseComparisonOperatorFactory getBaseComparisonOperatorFactory();

    protected abstract BaseGeographicalOperatorFactory getBaseGeographicalOperatorFactory();

    protected abstract BaseLogicalOperatorFactory getBaseLogicalOperatorFactory();

    protected abstract BaseSortOperatorFactory getBaseSortOperatorFactory();

    protected abstract BaseTextualOperatorFactory getBaseTextualOperatorFactory();


}
