package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RedisTest {
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
        //noSqlDbSystem.operateOn("test").filter(eq("cf:name", "George")).project("cf:surname").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        //noSqlDbSystem.operateOn("points").filter(and(lt("age",25),gt("age", 10),gt("fd",54))).printScreen();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

        Date d1 = sdf.parse("2019-11-11T11:00:00.000");
        Date d2 = sdf.parse("2019-11-11T11:30:00.000");

        //System.out.println(noSqlDbSystem.operateOn("points").filter(inGeoTemporalRectangle("location",Coordinates.newCoordinates(38.0,24.0), Coordinates.newCoordinates(38.9,24.9), "timestamp", d1,d2)).count());
        noSqlDbSystem.operateOn("passengerCars").toDataframe().show();

        System.out.println(NoSQLExpression.INSTANCE.getExpression());
        //noSqlDbSystem.operateOn("points").filter(gte("location:lon",24)).printScreen();
        noSqlDbSystem.closeConnection();
    }


}
