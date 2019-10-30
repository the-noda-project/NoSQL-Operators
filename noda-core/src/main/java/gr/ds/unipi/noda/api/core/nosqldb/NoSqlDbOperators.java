package gr.ds.unipi.noda.api.core.nosqldb;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.Optional;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators);

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    NoSqlDbOperators distinct(String fieldName);

    void printScreen();

    Optional<Double> max(String fieldName);

    Optional<Double> min(String fieldName);

    Optional<Double> sum(String fieldName);

    Optional<Double> avg(String fieldName);

    int count();

    NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators);

    NoSqlDbOperators limit(int limit);

    NoSqlDbOperators project(String fieldName, String... fieldNames);

    Dataset<Row> toDataframe(); /*{
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }*/
}
