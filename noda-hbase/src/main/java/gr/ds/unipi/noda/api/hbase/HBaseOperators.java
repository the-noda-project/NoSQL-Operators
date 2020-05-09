package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.*;

final class HBaseOperators extends NoSqlDbOperators {

    private final HBaseConnectionManager hbaseConnectionManager = HBaseConnectionManager.getInstance();
    private final Scan scan = new Scan();
    private final FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
    private final List<Map.Entry<byte[],byte[]>> projection = new ArrayList<>();

    private HBaseOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        super(connector, s, sparkSession);
    }

    static HBaseOperators newHBaseOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return new HBaseOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        filterList.addFilter((Filter) filterOperator.getOperatorExpression());
        for (FilterOperator fop : filterOperators) {
            filterList.addFilter((Filter) fop.getOperatorExpression());
        }
        return this;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        return null;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return null;
    }

    @Override
    public void printScreen() {
        Table table = null;
        ResultScanner resultScanner = null;
        scan.setFilter(filterList);
        projection.forEach(entry -> {
            if(entry.getValue()==null){
                scan.addFamily(entry.getKey());
            }
            else{
                scan.addColumn(entry.getKey(),entry.getValue());
            }
        });
        try {

            table = hbaseConnectionManager.getConnection(getNoSqlDbConnector()).getTable(TableName.valueOf(getDataCollection()));
            resultScanner = table.getScanner(scan);

            resultScanner.forEach(result -> System.out.println(result));

            resultScanner.close();
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        return Optional.empty();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        filterList.addFilter(new PageFilter(limit));
        return this;
    }


    private void scanProjection(String fieldName) {
        String[] names = fieldName.split(":");

        if (names.length == 1) {
            projection.add(new AbstractMap.SimpleImmutableEntry(Bytes.toBytes(names[0]),null));
        } else if (names.length == 2) {
            projection.add(new AbstractMap.SimpleImmutableEntry(Bytes.toBytes(names[0]),Bytes.toBytes(names[1])));
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {

        scanProjection(fieldName);

        for (int i = 0; i < fieldNames.length; i++) {
            scanProjection(fieldNames[i]);
        }

        return this;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }
}
