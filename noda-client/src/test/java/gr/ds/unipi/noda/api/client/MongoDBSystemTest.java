package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

public class MongoDBSystemTest {

    @Test
    public void mongodbTest() {

        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local").config("spark.mongodb.input.database","admin").config("spark.mongodb.input.collection", "inventory")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("myUserAdmin","myPass","admin").host("localhost").sparkSession(spark).build();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("inventory");

        noSqlDbOperators.toDataframe().show();
        noSqlDbSystem.closeConnection();

    }
}
