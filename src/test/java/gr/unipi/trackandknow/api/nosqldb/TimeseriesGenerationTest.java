package gr.unipi.trackandknow.api.nosqldb;

import org.apache.spark.sql.SparkSession;

public class TimeseriesGenerationTest {

    public static void main(String args[]){
        NoSqlDbSystem.initialize();

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).sparkSession(spark).build();

    }
}
