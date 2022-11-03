package gr.ds.unipi.noda.api.core.nosqldb;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Optional;

public abstract class NoSqlDbOperators {

    private final NoSqlDbConnector noSqlDbConnector;
    private final String dataCollection;
    private final SparkSession sparkSession;

    protected NoSqlDbOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        this.noSqlDbConnector = noSqlDbConnector;
        this.dataCollection = dataCollection;
        this.sparkSession = sparkSession;
    }


    abstract public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators);

    abstract public NoSqlDbOperators groupBy(String fieldName, String... fieldNames);

    abstract public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators);

    abstract public NoSqlDbOperators distinct(String fieldName);

    abstract public void printScreen();

    abstract public Optional<Double> max(String fieldName);

    abstract public Optional<Double> min(String fieldName);

    abstract public Optional<Double> sum(String fieldName);

    abstract public Optional<Double> avg(String fieldName);

    abstract public int count();

    abstract public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators);

    abstract public NoSqlDbOperators limit(int limit);

    abstract public NoSqlDbOperators project(String fieldName, String... fieldNames);

    abstract public Dataset<Row> toDataframe(); /*{
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }*/

    abstract public NoSqlDbOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo);

    public NoSqlDbConnector getNoSqlDbConnector() {
        return noSqlDbConnector;
    }

    public String getDataCollection() {
        return dataCollection;
    }

    public SparkSession getSparkSession() {
        return sparkSession;
    }

}
