package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.sql.NoSqlDbSqlStatement;
import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

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

    NoSqlDbSqlStatement a = noSqlDbSystem.sql("SELECT* FROM passengerCars WHERE GEO_CIRCLE_KM(location, ( 23.589384555816654, 38.462788183083674 ), 0.064081550350987 )");

    a.toDataframe().show();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    Date d1 = sdf.parse("2018-08-16T11:00:00.000");
    Date d2 = sdf.parse("2018-08-29T11:30:00.000");

    //noSqlDbSystem.operateOn("passengerCars").filter(inGeoCircleMeters("location", Coordinates.newCoordinates(23.5323, 38.4874),5000)).toDataframe().printSchema();


    System.out.println(NoSQLExpression.INSTANCE.getExpression());
    noSqlDbSystem.closeConnection();
}
}
