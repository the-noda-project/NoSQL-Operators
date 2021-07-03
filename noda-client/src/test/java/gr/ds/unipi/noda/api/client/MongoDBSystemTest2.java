package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.mongo.MongoDBSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MongoDBSystemTest2 {

    public static NoSqlDbSystem noSqlDbSystem;

    @Test
    public void mongodbTest() throws ParseException {
        //MongoDBSystem.initialize();

        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//
//        System.out.println(sdf.parse("2018-08-15T00:00:00.000").getTime());
//        System.out.println(sdf.parse("2018-08-31T23:59:59.999").getTime());
        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local")//.config("spark.mongodb.input.database","trajectories").config("spark.mongodb.input.collection", "passengerCars")
                //.config("spark.mongodb.input.uri", "mongodb://myUserAdmin:myPass@localhost:27017/trajectories").config("spark.mongodb.input.collection", "passengerCars")//.config("spark.mongodb.input.database", "trajectories")
                .getOrCreate();

        //spark.conf().getAll();

        //MongoDBSystem.initialize();
//        if(spark.conf().contains("spark.mongodb.input.uri")){
//            System.out.println("true");
//        }else{
//            System.out.println("SET");
//            spark.conf().set("spark.mongodb.input.uri", "mongodb://myUserAdmin:myPass@localhost:27017");
//        }
//
//        if(spark.conf().contains("spark.mongodb.input.uri")){
//            System.out.println("TRUE");
//        }
//
//        if(spark.conf().contains("spark.mongodb.input.database")){
//            System.out.println("true");
//        }else{
//            System.out.println("SET");
//            spark.conf().set("spark.mongodb.input.database", "trajectories");
//        }
//
//        if(spark.conf().contains("spark.mongodb.input.collection")){
//            System.out.println("true");
//        }else{
//            System.out.println("SET");
//            spark.conf().set("spark.mongodb.input.collection", "passengerCars");
//        }

        noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("myUserAdmin","myPass","trajectories").host("localhost").sparkSession(spark).build();
        //NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("passengerCars");

        //noSqlDbOperators = noSqlDbOperators.filter(inGeoCircleMeters("location",Coordinates.newCoordinates(25.975396, 39.543451),0.1));

        //noSqlDbOperators = noSqlDbOperators.filter(inGeoRectangle("location",Coordinates.newCoordinates(25.90, 39.6),Coordinates.newCoordinates(25.99, 39.7)));

        System.out.println(noSqlDbSystem.sql("SELECT * FROM passengerCars WHERE GEO_TEMPORAL_RECTANGLE(location, (23.7533, 37.9801), (23.7598, 37.9910), date, '15/8/2018 00:00:03', '31/8/2018 23:59:52')").toDataframe().count());
        //System.out.println(noSqlDbOperators.toDataframe().count());

        noSqlDbSystem.closeConnection();

        noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("myUser","myPass","newTraj").host("localhost").sparkSession(spark).build();

        System.out.println(noSqlDbSystem.sql("SELECT * FROM passengerCars").toDataframe().count());

        noSqlDbSystem.closeConnection();

        spark.close();

//        SparkSession spark1 = SparkSession
//                .builder()
//                .appName("redis-df")
//                .master("local[*]")
//                .config("spark.redis.host", "localhost")
//                .config("spark.redis.port", "6379")
//                .getOrCreate();
//
//        System.out.println("Starting Redis");
//        noSqlDbSystem = NoSqlDbSystem.Redis().Builder().port(6379).sparkSession(spark1).soTimeout(0).connectionTimeout(0).build();
//        System.out.println(noSqlDbSystem.sql("SELECT * FROM passengerCars WHERE GEO_TEMPORAL_RECTANGLE(location, (23.7533, 37.9801), (23.7598, 37.9910), date, '15/8/2018 00:00:05', '31/8/2018 22:59:59')").toDataframe().count());
//
//        noSqlDbSystem.closeConnection();
//
//        spark1.close();


        SparkSession sparkSession = SparkSession
                .builder()
                .appName("My App").master("local")
                .getOrCreate();

        sparkSession.conf().set("spark.mongodb.input.uri", "mongodb://myUserAdmin:myPass@localhost:27017/trajectories.passengerCars");
    }
}
