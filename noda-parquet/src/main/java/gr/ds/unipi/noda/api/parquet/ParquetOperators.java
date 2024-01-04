package gr.ds.unipi.noda.api.parquet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.parquet.classes.NoSqlDbReadSupport;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.filter2.compat.FilterCompat;
import org.apache.parquet.filter2.predicate.FilterApi;
import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.io.RecordReader;
import org.apache.parquet.tools.json.JsonRecordFormatter;
import org.apache.parquet.tools.read.SimpleReadSupport;
import org.apache.parquet.tools.read.SimpleRecord;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

final class ParquetOperators extends NoSqlDbOperators {

    private final List<FilterPredicate> fp;
    private final List<String> project;
    private final ParquetConnectionManager parquetConnectionManager = ParquetConnectionManager.getInstance();
    //to access the database's object for connectivity, call parquetConnectionManager.getConnection(getNoSqlDbConnector())
    //to access the defined name of collection or table, call  getDataCollection()
    //to access the SparkSession, call getSparkSession()


    private ParquetOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        fp = new ArrayList<>();
        project = new ArrayList<>();
    }

    private ParquetOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession, List<FilterPredicate> fp, List<String> project) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        this.fp = fp;
        this.project = project;
    }

    static ParquetOperators newParquetOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new ParquetOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        List<FilterPredicate> fp =new ArrayList<>(this.fp);
        List<String> project = new ArrayList<>(this.project);

        fp.add((FilterPredicate) filterOperator.getOperatorExpression());
        for (FilterOperator operator : filterOperators) {
            fp.add((FilterPredicate) operator.getOperatorExpression());
        }
        return new ParquetOperators(getNoSqlDbConnector(), getDataCollection(), getSparkSession(), fp, project);
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
        return null;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        List<FilterPredicate> fp =new ArrayList<>(this.fp);
        List<String> project = new ArrayList<>(this.project);

        project.add(fieldName);
        for (String name : fieldNames) {
            project.add(name);
        }

        return new ParquetOperators(getNoSqlDbConnector(), getDataCollection(), getSparkSession(), fp, project);
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

    @Override
    public NoSqlDbOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        return null;
    }

    @Override
    public NoSqlDbResults getResults() {

        boolean hasFilter = true;
        try {
            ParquetReader<ParquetRecord> data = ParquetReader.builder(new NoSqlDbReadSupport(project), new Path("/Users/nicholaskoutroumanis/Desktop/parquet-files"))
    //                .withFilter(FilterCompat.get(FilterApi.and(
    //                        FilterApi.and(
    //                                FilterApi.gtEq(xColumn, xMin),
    //                                FilterApi.ltEq(xColumn, xMax)
    //                        ),
    //                        FilterApi.and(
    //                                FilterApi.gtEq(yColumn, yMin),
    //                                FilterApi.ltEq(yColumn, yMax)
    //                        )
    //                )))
                    // - don't use record filters for x,y
                    // - only a custom filter for an entire geometry object
                    //   can be used instead.
                    .useRecordFilter(true)
                    .useDictionaryFilter(true)
                    .useBloomFilter(true)
                    .useColumnIndexFilter(hasFilter)
                    .useSignedStringMinMax(true)
                    // use this to filter column blocks based on range
                    .useStatsFilter(hasFilter)
                    .build();
            return new ParquetResults(data);

//            ParquetRecord sr;
//            while ((sr = data.read())!=null){
//                for (ParquetRecord.NameValue value : sr.getValues()) {
//                    System.out.println(value.getName() + "-"+ value.getValue());
//                    System.out.println(value.getValue().getClass());
////                    System.out.println(sr.toJsonObject());
//                }
//                break;
//            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
