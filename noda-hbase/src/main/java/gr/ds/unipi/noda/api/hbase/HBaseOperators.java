package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaSparkContext$;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.*;
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;
import org.apache.spark.sql.execution.datasources.csv.CSVInferSchema;
import org.apache.spark.sql.types.*;
import scala.Tuple2;
import scala.collection.JavaConverters;

import java.io.IOException;
import java.util.Optional;

final class HBaseOperators extends NoSqlDbOperators {

    private final HBaseConnectionManager hbaseConnectionManager = HBaseConnectionManager.getInstance();
    private final Scan scan = new Scan();
    private final FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);

    private final FilterList projectionFilterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);

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

        filterList.addFilter(projectionFilterList);
        scan.setFilter(filterList);

        try {

            table = hbaseConnectionManager.getConnection(getNoSqlDbConnector()).getTable(TableName.valueOf(getDataCollection()));
            resultScanner = table.getScanner(scan);
            resultScanner.forEach(System.out::println);

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
            projectionFilterList.addFilter(new FamilyFilter(CompareOperator.EQUAL, new BinaryComparator(Bytes.toBytes(names[0]))));
        } else if (names.length == 2) {

            FilterList flist = new FilterList(FilterList.Operator.MUST_PASS_ALL);

            flist.addFilter(new FamilyFilter(CompareOperator.EQUAL, new BinaryComparator(Bytes.toBytes(names[0]))));
            flist.addFilter(new QualifierFilter(CompareOperator.EQUAL, new BinaryComparator(Bytes.toBytes(names[1]))));

            projectionFilterList.addFilter(flist);

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

        filterList.addFilter(projectionFilterList);
        scan.setFilter(filterList);

        Configuration conf = hbaseConnectionManager.getConfiguration(getNoSqlDbConnector());
        conf.set(TableInputFormat.INPUT_TABLE,getDataCollection());
        try {
            conf.set(TableInputFormat.SCAN, TableMapReduceUtil.convertScanToString(scan));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaPairRDD<ImmutableBytesWritable, Result> javaPairRDD = JavaSparkContext.fromSparkContext(getSparkSession().sparkContext()).newAPIHadoopRDD(conf,TableInputFormat.class, ImmutableBytesWritable.class, Result.class);

        Dataset<Row> df = getSparkSession().sqlContext().createDataFrame(javaPairRDD.values(), Result.class);

        df = df.select(new Column("row"),org.apache.spark.sql.functions.explode_outer(new Column("noVersionMap"))).select(new Column("row"), new Column("key").as("columnFamily"), org.apache.spark.sql.functions.explode_outer(new Column("value"))).select(new Column("row").cast(DataTypes.StringType),new Column("columnFamily").cast(DataTypes.StringType),new Column("key").cast(DataTypes.StringType).as("columnQualifier"),new Column("value").cast(DataTypes.StringType))
                .withColumn("column",org.apache.spark.sql.functions.concat(new Column("columnFamily"),org.apache.spark.sql.functions.lit(":"), new Column("columnQualifier"))).drop("columnFamily","columnQualifier").groupBy("row").pivot("column").agg(org.apache.spark.sql.functions.first(new Column("value")));

        return df;
    }
}
