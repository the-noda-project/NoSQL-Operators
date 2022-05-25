package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.sql.NoSqlDbSqlStatement;
import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.redis.dataframe.visualization.RedisDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static org.apache.spark.sql.functions.array;
import static org.apache.spark.sql.functions.col;

public class Redis {
    @Ignore
@Test
public void redisTest() throws ParseException {

    SparkSession spark = SparkSession
            .builder()
            .appName("redis-df")
            .master("local[*]")
            .config("spark.redis.host", "localhost")
            .config("spark.redis.port", "6379")
            .getOrCreate();

    NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Redis().Builder().port(6379).sparkSession(spark).soTimeout(0).connectionTimeout(0).build();

    NoSqlDbSqlStatement a = noSqlDbSystem.sql("SELECT * FROM passengerCars WHERE GEO_TEMPORAL_CIRCLE_KM( location , ( 22.431753353946977 ,37.072546550788154 ), 0.8345087437616381 , date , '16/08/2018 00:00:00' , '22/08/2018 00:00:00' ) )");

    a.toDataframe().show();

    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    //Date d1 = sdf.parse("2018-08-16T00:00:00.000");
    //Date d2 = sdf.parse("2018-08-18T00:00:00.000");

    //noSqlDbSystem.operateOn("passengerCars").filter(inGeoCircleKm("location", Coordinates.newCoordinates(23.589325547218326 ,38.462779782272634 ), 0.06091383257192586)).toDataframe().show(60,false);

    //noSqlDbSystem.operateOn("passengerCars").filter(inGeoTemporalCircleKm("location", Coordinates.newCoordinates(23.589325547218326 ,38.462779782272634 ), 0.06091383257192586, "date", d1, d2)).toDataframe().show(60,false);

    //noSqlDbSystem.operateOn("passengerCars").filter(inGeoCircleMeters("location", Coordinates.newCoordinates(23.5323, 38.4874),5000)).toDataframe().printSchema();

    System.out.println(NoSQLExpression.INSTANCE.getExpression());
    noSqlDbSystem.closeConnection();
}
}
