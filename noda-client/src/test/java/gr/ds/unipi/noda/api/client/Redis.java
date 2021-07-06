package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    Date d1 = sdf.parse("2019-11-11T11:00:00.000");
    Date d2 = sdf.parse("2019-11-11T11:30:00.000");

    noSqlDbSystem.operateOn("passengerCars").limit(4).limit(1).limit(3).toDataframe().show();

    System.out.println(NoSQLExpression.INSTANCE.getExpression());
    noSqlDbSystem.closeConnection();
}
}
