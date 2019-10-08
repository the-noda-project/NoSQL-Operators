package gr.unipi.noda.api.core.nosqldb;

import gr.unipi.noda.api.core.operators.Operators;
import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import org.apache.spark.sql.SparkSession;

public abstract class NoSqlConnectionFactory {

    protected NoSqlConnectionFactory() {
        setBaseAggregateOperator();
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

    private void setBaseAggregateOperator() {
        Operators.aggregateOperator = getAggregateOperatorFactory();
    }

    protected abstract BaseAggregateOperatorFactory getAggregateOperatorFactory();
}
