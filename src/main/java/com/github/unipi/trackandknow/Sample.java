package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.connectivity.NoSqlDbSystem;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Sample {

    public static void main(String args[]){
        NoSqlDbSystem.initialize();

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                //.config("spark.mongodb.input.uri", "mongodb://1.1.1.1:27017/test.points ")
                .getOrCreate();

        //NoSqlDbSystem noSqlDbSystem1 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(27017).sparkSession(spark).connect();

        //noSqlDbSystem.operateOn("geoPoints").filter(inGeoBox("location",22.5, 36,23, 36.3)).groupBy("theColumn",max("s","adsasd")).project();
        //System.out.println(noSqlDbSystem.operateOn("geoPoints").max("location.coordinates"));

        //System.out.println("points COUNT: "+noSqlDbSystem1.operateOn("points").filter(FilterOperators.inGeoCircleMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).toDataframe().count());

        NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).sparkSession(spark).connect();
        Dataset<Row> d = noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(23.76,37.99),100)).toDataframe();

        System.out.println(d.count());
        System.out.println("OK!");
        d.count();

        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).count());

        //noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).printScreen();
        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.eq("objectId","15320_135320")).count());
        //noSqlDbSystem1.closeConnection();
        noSqlDbSystem2.closeConnection();
        spark.close();
    }
}
