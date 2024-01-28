package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.parquet.classes.NoSqlDbReadSupport;
import gr.ds.unipi.noda.api.parquet.classes.Record;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.ParquetTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.OperatorInGeoTemporalRectangle;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.TrajectoryGeoTemporalOperator;
import org.apache.hadoop.fs.Path;
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
            ParquetReader<Document> data = ParquetReader.builder(new NoSqlDbReadSupport(project), new Path("/Users/nicholaskoutroumanis/Desktop/trajparquet-noda"))
//                    .withFilter(FilterCompat.get(FilterApi.and(
//                            FilterApi.and(
//                                    FilterApi.gtEq(xColumn, xMin),
//                                    FilterApi.ltEq(xColumn, xMax)
//                            ),
//                            FilterApi.and(
//                                    FilterApi.gtEq(yColumn, yMin),
//                                    FilterApi.ltEq(yColumn, yMax)
//                            )
//                    )))
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

//            List<Document> documentsList = OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle("null","null",null,null).refinement(data);
//            List<Document> documentsList = new ArrayList<>();

//            Document doc = null;
//            while ((doc = data.read() ) != null ){
////                System.out.println(doc.get("segment"));
//
//                Document document = (Document) doc.get("segment");
//
//                byte[] bytesS = Base64Variants.getDefaultVariant().decode(doc.getString("objectId").replaceAll(":","="));
//                byte[] bytes = Base64Variants.getDefaultVariant().decode(document.getString("latitude").replaceAll(":","="));//document.getString("timestamps").replaceAll(":","=").getBytes();
////                byte[] bytes = ((Binary)document.get("timestamps")).getData();
//
//                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//                int cap = byteBuffer.capacity()/8;
//                for (int i = 0; i < cap; i++) {
//                    System.out.println(byteBuffer.getDouble() + " -" +cap +" - "+new String(bytesS));
//                }
//
//                byte[] bytes1 = Base64Variants.getDefaultVariant().decode(document.getString("timestamps").replaceAll(":","="));//document.getString("timestamps").replaceAll(":","=").getBytes();
////                byte[] bytes = ((Binary)document.get("timestamps")).getData();
//
//                ByteBuffer byteBuffer1 = ByteBuffer.wrap(bytes1);
//                int cap1 = byteBuffer1.capacity()/8;
//                for (int i = 0; i < cap1; i++) {
//                    System.out.println(byteBuffer1.getLong() + " -" +cap1 +" - "+new String(bytesS));
//                }
//
//                if(cap != cap1){
//                    try {
//                        throw new Exception("different size");
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                documentsList.add(doc);
//            }
            return new ParquetResults(data, OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle("null","null",null,null));
//            return new ParquetResults(data);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
