package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.redis.filterOperators.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperators.Triplet;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.and;

final class RedisOperators extends NoSqlDbOperators {

    private final RedisConnectionManager redisConnectionManager = RedisConnectionManager.getInstance();
    private final Map<String, Pipeline> pipelines;
    private final List<FilterOperator> filterOperatorsList;
    
    private final StringBuilder sb = new StringBuilder();
    private final List<String> project;
    private int limit = -1;

    private RedisOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        pipelines = redisConnectionManager.getConnection(getNoSqlDbConnector());
        this.filterOperatorsList = new ArrayList<>();
        this.project = new ArrayList<>();
    }

    private RedisOperators(RedisOperators redisOperators, List<FilterOperator> filterOperatorsList, List<String> project, int limit) {
        super(redisOperators.getNoSqlDbConnector(), redisOperators.getDataCollection(), redisOperators.getSparkSession());
        pipelines = redisOperators.getPipelines();
        this.filterOperatorsList = filterOperatorsList;
        this.project = project;
        this.limit = limit;
    }

    private Map<String, Pipeline> getPipelines() {
        return pipelines;
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

        for (Triplet triplet : triplets) {

            String[] arrayOfArguments = new String[triplet.getKeysArray().length + triplet.getArgvArray().length];

            for (int i = 0; i < triplet.getKeysArray().length; i++) {
                arrayOfArguments[i] = getDataCollection() + ":" + triplet.getKeysArray()[i]+crc16Slot;
            }

            for (int i = triplet.getKeysArray().length; i < triplet.getKeysArray().length + triplet.getArgvArray().length; i++) {
                arrayOfArguments[i] = triplet.getArgvArray()[i-triplet.getKeysArray().length];
            }

            for (int k = 0; k < arrayOfArguments.length; k++) {
                if(k<triplet.getKeysArray().length){
                    sb.append("KEY["+(k+1)+"]="+arrayOfArguments[k]+", ");
                }
                else{
                    sb.append("ARGV["+(k+1-triplet.getKeysArray().length)+"]="+arrayOfArguments[k]+", ");
                }
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.append("\n"+triplet.getEvalExpression()+"\n\n");
            pipelines.get(crc16Slot).eval(triplet.getEvalExpression(), triplet.getKeysArray().length, arrayOfArguments);
        }

        return getDataCollection() + ":" + triplets.get(triplets.size()-1).getKeysArray()[0]+crc16Slot;
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        List<FilterOperator> fl = new ArrayList<>(filterOperatorsList);

        fl.add(filterOperator);
        for (FilterOperator operator : filterOperators) {
            fl.add(operator);
        }
        return new RedisOperators(this, fl, project, limit);
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
        List<Response<Object>> counts = new ArrayList<>();

        pipelines.forEach((s,pipeline)->{
            String expr = "local s = redis.call('SCARD', KEYS[1])\nreturn s;";
            String entry = executionOfOperators(s);
            counts.add(pipeline.eval(expr,1, entry));
            sb.append("KEY[1]="+entry+" \n");
            sb.append(expr+"\n\n");
            }
        );

        NoSQLExpression.INSTANCE.setExpression(sb.toString());
        long start = System.currentTimeMillis();
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
        if(limit == -1){
            for (Response<Object> response : counts) {
                count = Integer.valueOf(response.get().toString()) + count;
            }
        }else{
            for (Response<Object> response : counts) {
                count = Math.min(Integer.valueOf(response.get().toString()), limit) + count;
            }
        }
        RedisConnectionFactory.times.add(System.currentTimeMillis()-start);
        return count;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        //the limit operator resembles to the PageFilter of HBase. It is applied individually on each node.
        //if a user defines more than once the limit, the min is chosen
        if(limit<0){
            throw new IllegalArgumentException("limit must be positive");
        }else{
            if(this.limit < limit && this.limit != -1){
                return new RedisOperators(this, filterOperatorsList, project, this.limit);
            }
            else{
                return new RedisOperators(this, filterOperatorsList, project, limit);
            }
        }
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        project.add(fieldName);
        for (String name : fieldNames) {
            project.add(name);
        }
        return new RedisOperators(this, filterOperatorsList, project, limit);
    }

    @Override
    public Dataset<Row> toDataframe() {

        String randomPrefix = RandomStringGenerator.randomCharacterNumericString()+":";

        String d;

        if(project.isEmpty()) {
            d = "local s = redis.call('SMEMBERS', KEYS[1])\n" +
                    "local i = 1\n" +
                    "local t = {}\n" +
                    "local r = #s\n" +
                    "local limit = tonumber(ARGV[1])\n" +
                    "if( limit ~= -1 and limit < r ) then\n" +
                    "    r = limit\n" +
                    "end\n" +
                    "while(i <= r) do\n" +
                    "    t = redis.call('DUMP', s[i])\n" +
                    "    redis.call('RESTORE', KEYS[2] .. s[i], 100000, t)\n" +
                    "    i = i + 1\n" +
                    "end\n" +
                    "return 1;\n";
        }
        else {
            StringBuilder fields = new StringBuilder();
            project.forEach(s -> fields.append(", ").append("'"+s+"'"));

            StringBuilder fieldsAndArgs = new StringBuilder();
            for (int i = 0; i < project.size(); i++) {
                fieldsAndArgs.append(", '"+project.get(i)).append("', ").append("t[" + (i + 1) + "]");
            }

            d = "local s = redis.call('SMEMBERS', KEYS[1])\n" +
                    "local i = 1\n" +
                    "local t = {}\n" +
                    "local r = #s\n" +
                    "local limit = tonumber(ARGV[1])\n" +
                    "if( limit ~= -1 and limit < r ) then\n" +
                    "    r = limit\n" +
                    "end\n" +
                    "while(i <= r) do\n" +
                    "    t = redis.call('HMGET', s[i]" + fields + " )\n" +
                    "    redis.call('HMSET', KEYS[2] .. s[i] " + fieldsAndArgs + ")\n" +
                    "    redis.call('EXPIRE' , KEYS[2] .. s[i], 100)\n"+
                    "    i = i + 1\n" +
                    "end\n" +
                    "return 1;\n";
        }

        pipelines.forEach((s,pipeline)-> {
            String entry = executionOfOperators(s);
            pipeline.eval(d, 2, entry, randomPrefix, String.valueOf(limit));
            sb.append("KEY[1]="+entry+", "+"KEY[2]="+randomPrefix+" ARGV[1]="+limit+" \n");
            sb.append(d+"\n\n");
            }
        );

        NoSQLExpression.INSTANCE.setExpression(sb.toString());

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

        Dataset<Row> dataset = getSparkSession().read().format("org.apache.spark.sql.redis")
                .option("infer.schema", true).option("keys.pattern", randomPrefix+"*")
                .load();

        return dataset;
    }

    @Override
    public NoSqlDbOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        return null;
    }

}
