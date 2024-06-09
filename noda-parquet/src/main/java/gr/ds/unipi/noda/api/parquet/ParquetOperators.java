package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.parquet.classes.NoSqlDbReadSupport;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.OperatorInGeoTemporalRectangle;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.filter2.compat.FilterCompat;
import org.apache.parquet.filter2.predicate.FilterApi;
import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.bson.types.Binary;
import shaded.parquet.com.fasterxml.jackson.core.Base64Variants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

final class ParquetOperators extends NoSqlDbOperators {

    private final List<FilterOperator> fp;
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

    private ParquetOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession, List<FilterOperator> fp, List<String> project) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        this.fp = fp;
        this.project = project;
    }

    static ParquetOperators newParquetOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new ParquetOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        List<FilterOperator> fp =new ArrayList<>(this.fp);
        List<String> project = new ArrayList<>(this.project);

        fp.add(/*(FilterPredicate)*/ filterOperator/*.getOperatorExpression()*/);
        for (FilterOperator operator : filterOperators) {
            fp.add(/*(FilterPredicate)*/ operator/*.getOperatorExpression()*/);
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
        List<FilterOperator> fp =new ArrayList<>(this.fp);
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
            ParquetReader.Builder<Document> dataBuilder = ParquetReader.builder(new NoSqlDbReadSupport(project), new Path("/Users/nicholaskoutroumanis/Desktop/trajparquet-noda"));
            if(!fp.isEmpty()){
                dataBuilder = dataBuilder.withFilter(FilterCompat.get(formPushdownPredicateFilter()));
            }
             // - don't use record filters for x,y
                    // - only a custom filter for an entire geometry object
                    //   can be used instead.
                    ParquetReader<Document> data  = dataBuilder.useRecordFilter(true)
                    .useDictionaryFilter(true)
                    .useBloomFilter(true)
                    .useColumnIndexFilter(hasFilter)
                    .useSignedStringMinMax(true)
                    // use this to filter column blocks based on range
                    .useStatsFilter(hasFilter)
                    .build();

            return new ParquetResults(data, (OperatorInGeoTemporalRectangle) fp.get(0));
//            return new ParquetResults(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private FilterPredicate formPushdownPredicateFilter(){
        if(fp.size()==1){
            return (FilterPredicate) fp.get(0).getOperatorExpression();
        }else{
            FilterPredicate f = FilterApi.and((FilterPredicate) fp.get(0).getOperatorExpression(), (FilterPredicate) fp.get(1).getOperatorExpression());
            if(fp.size()==2){
                return f;
            }
            for (int i = 2; i < fp.size(); i++) {
                f = FilterApi.and(f, (FilterPredicate) fp.get(i).getOperatorExpression());
            }
            return f;
        }
    }
}
