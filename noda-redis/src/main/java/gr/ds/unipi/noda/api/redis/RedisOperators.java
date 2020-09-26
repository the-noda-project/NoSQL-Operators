package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.redis.filterOperator.logicalOperators.LogicalOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import redis.clients.jedis.Pipeline;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

final class RedisOperators extends NoSqlDbOperators {

    private final RedisConnectionManager redisConnectionManager = RedisConnectionManager.getInstance();
    private final Pipeline pipeline;

    private RedisOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        pipeline = redisConnectionManager.getConnection(getNoSqlDbConnector()).getResource().pipelined(); }

    static RedisOperators newRedisOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new RedisOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        List<Map.Entry<String, String[]>> list = (List<Map.Entry<String, String[]>>) filterOperator.getOperatorExpression();

        for(int i =0; i<list.size();i++){

            //if string has 4 elements
            //else if equals eqString
            //else

            String[] keys = list.get(i).getValue();
            for (int keyIndex = 0; keyIndex < keys.length; keyIndex++) {
                keys[keyIndex] = getDataCollection() + ":" + keys[keyIndex];
            }

            pipeline.eval(list.get(i).getKey(),keys.length, keys);


//            pipeline.eval(list.get(i).getValue()[0],2, getDataCollection() +":"+list.get(i).getValue()[1], /*getDataCollection() +":"+list.get(i).getValue()[2]*/"ad");
//            System.out.println("its ok "+ getDataCollection() +":"+list.get(i).getValue()[1]);
//            System.out.println("its ok "+ getDataCollection() +":"+list.get(i).getValue()[2]);
//            System.out.println(list.get(i).getValue()[0]);
//
//            if(list.get(i).getValue()[0].equals("eq")){
//
//            }else if(list.get(i).getValue()[0].equals("neqNumeric")){
//
//            }
        }


        pipeline.sync();

//        System.out.println(filterOperator.toString(""));

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
        return null;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

}
