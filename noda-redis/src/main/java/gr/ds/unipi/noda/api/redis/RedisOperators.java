package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.redis.filterOperators.Triplet;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.and;

final class RedisOperators extends NoSqlDbOperators {

    private final RedisConnectionManager redisConnectionManager = RedisConnectionManager.getInstance();
    private final Map<String, Pipeline> pipelines;
    private final List<FilterOperator> filterOperatorsList = new ArrayList<>();

    private RedisOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        pipelines = redisConnectionManager.getConnection(getNoSqlDbConnector());
    }

    static RedisOperators newRedisOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new RedisOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    private String executionOfOperators(String crc16Slot){
        FilterOperator fop;

        if(filterOperatorsList.size() == 0) {
            return getDataCollection()+":primaryKeys"+crc16Slot;
        }
        else if(filterOperatorsList.size() == 1){
            fop = filterOperatorsList.get(0);

        }
        else if(filterOperatorsList.size() ==2){
            fop = and(filterOperatorsList.get(0),filterOperatorsList.get(1));
        }
        else{
            FilterOperator[] fops = new FilterOperator[filterOperatorsList.size()-2];
            for (int i = 2; i < filterOperatorsList.size(); i++) {
                fops[i-2] = filterOperatorsList.get(i);
            }
            fop = and(filterOperatorsList.get(0),filterOperatorsList.get(1),fops);
        }

        List<Triplet> triplets = (List<Triplet>) fop.getOperatorExpression();

        //System.out.println("Triplets "+ triplets.size());

        for (Triplet triplet : triplets) {

            String[] arrayOfArguments = new String[triplet.getKeysArray().length + triplet.getArgvArray().length];

            for (int i = 0; i < triplet.getKeysArray().length; i++) {
                arrayOfArguments[i] = getDataCollection() + ":" + triplet.getKeysArray()[i]+crc16Slot;
            }

            for (int i = triplet.getKeysArray().length; i < triplet.getKeysArray().length + triplet.getArgvArray().length; i++) {
                arrayOfArguments[i] = triplet.getArgvArray()[i-triplet.getKeysArray().length];
            }

            pipelines.get(crc16Slot).eval(triplet.getEvalExpression(), triplet.getKeysArray().length, arrayOfArguments);
            //pipelines.forEach(entry -> entry.getValue().eval(triplet.getEvalExpression(), triplet.getKeysArray().length, arrayOfArguments));
            //pipeline.eval(triplet.getEvalExpression(), triplet.getKeysArray().length, arrayOfArguments);
        }

//        System.out.println(triplets.get(triplets.size()-1).getKeysArray()[0] + " " + triplets.get(triplets.size()-1).getKeysArray()[1] + " " +triplets.get(triplets.size()-1).getKeysArray()[2] + " " +triplets.get(triplets.size()-1).getKeysArray()[3]);


        return getDataCollection() + ":" + triplets.get(triplets.size()-1).getKeysArray()[0]+crc16Slot;

    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        filterOperatorsList.add(filterOperator);
        for (FilterOperator operator : filterOperators) {
            filterOperatorsList.add(operator);
        }
        return this;
    }


//        System.out.println(filterOperators.toString(""));

//        for (int i = 0; i < list.size(); i++) {
//            Map.Entry<Operator, String[]> entry = list.get(i);
//
//            if(entry.getKey() instanceof ComparisonOperator){
//                ComparisonOperator comparisonOperator = (ComparisonOperator) entry.getKey();
//
//                if(comparisonOperator.getFieldValue() instanceof String){
//                    if(comparisonOperator.getComparisonOperatorType().equals("eq")){
//                        //REDIS OP
//                    }
//                    else if(comparisonOperator.getComparisonOperatorType().equals("ne")){
//                        //REDIS OP
//                    }
//                    else{
//                        try {
//                            throw new Exception("Unknown comparison operator for String type constraint");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                else {
//
//                    String
//
//                    switch(comparisonOperator.getComparisonOperatorType()){
//                        case "eq":
//                            //REDIS OP
//                            break;
//                        case "gt":
//                            //REDIS OP
//                            break;
//                        case "gte":
//                            //REDIS OP
//                            break;
//                        case "lt":
//                            //REDIS OP
//                            break;
//                        case "lte":
//                            //REDIS OP
//                            break;
//                        case "ne":
//                            //REDIS OP
//                            break;
//                            default:
//                                try {
//                                    throw new Exception("Unknown comparison operator for Numeric type constraint");
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                    }
//                }
//            }
//            else if(entry.getKey() instanceof LogicalOperator){
//                LogicalOperator logicalOperator = (LogicalOperator) entry.getKey();
//
//                String destination = entry.getValue()[0];
//                String[] existingSets = new String[entry.getValue().length-1];
//                for (int k = 1; k < entry.getValue().length; k++) {
//                    existingSets[k-1]=entry.getValue()[k];
//                }
//
//                if(logicalOperator.getLogicalOperatorType().equals("and")){
//                    pipeline.sunionstore(destination, existingSets);
//                }else if(logicalOperator.getLogicalOperatorType().equals("or")){
//                    pipeline.sinterstore(destination, existingSets);
//                }else{
//                    try {
//                        throw new Exception("Unknown logical operator");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
////            else if(entry.getKey() instanceof GeographicalOperator){
////                GeographicalOperator geographicalOperator = (GeographicalOperator) entry.getKey();
////
////            }
////            else if(entry.getKey() instanceof TextualOperator){
////
////            }
//            else{
//                try {
//                    throw new Exception("Unknown Operator");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return this;
//    }

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
        List<Response<Object>> counts = new ArrayList<>();

        pipelines.forEach((s,pipeline)->
            counts.add(pipeline.eval("local s = redis.call('SCARD', KEYS[1])\nreturn s;",1, executionOfOperators(s)))
        );

        long t1 = System.currentTimeMillis();
//        pipelines.entrySet().parallelStream().forEach((entry)->{
//            entry.getValue().sync();
//            System.out.println(entry.getKey());}
//        );


        ExecutorService es = Executors.newCachedThreadPool();
        pipelines.forEach((s,pipeline)->
                {es.execute(new Runnable() {
                    @Override
                    public void run() {
                        pipeline.sync();
                    }
                });
                }
        );
        es.shutdown();

        try {
            boolean finshed = es.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = 0;
        for (Response<Object> response : counts) {
            count = Integer.valueOf(response.get().toString()) + count;
        }

        System.out.println((System.currentTimeMillis()- t1));

        //Response<Object> count = pipeline.eval("local s = redis.call('SCARD', KEYS[1])\nreturn s;",1, executionOfOperators());
        //pipeline.sync();
        //return Integer.valueOf(count.get().toString());
        return count;
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
        return null;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

}
