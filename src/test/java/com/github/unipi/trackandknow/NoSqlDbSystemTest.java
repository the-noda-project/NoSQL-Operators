package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.connectivity.NoSqlDbSystem;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

public class NoSqlDbSystemTest {

    @Test
    public void makeAConnection(){

        NoSqlDbSystem.initialize();

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                //.config("spark.mongodb.input.uri", "mongodb://1.1.1.1:27017/test.points ")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(27017).sparkSession(spark).connect();

        //noSqlDbSystem.operateOn("geoPoints").filter(inGeoBox("location",22.5, 36,23, 36.3)).groupBy("theColumn",max("s","adsasd")).project();
        //System.out.println(noSqlDbSystem.operateOn("geoPoints").max("location.coordinates"));

        System.out.println("COUNT: "+noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).toDataframe().count());

        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).count());

        //noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).printScreen();
        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.eq("objectId","15320_135320")).count());
        noSqlDbSystem.closeConnection();

        //spark.close();
//        NoSqlDbManager manager = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect()
//                .getNoSqlDbManager();
//
//        NoSqlDbOperators operateOnSpecificCollection = manager.operateOn("otherCollection");
//
//        operateOnSpecificCollection.project("aColumn","bColumn");
//
//        manager.disconnect(3);
//



//        NoSqlDbSystem v = new NoSqlDbSystem();
//
//        NoSqlDbSystem dbSystem = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect();
//
//        dbSystem.operateOn("").filter().filter().project();
//
//        dbSystem.operateOn("Collection").aggragation().filter().filter(ColumnName,lambda).projectFilteredColumns();
//        dbSystem.operateOn(Collection).filter(ColumnName,lambda).filter(ColumnName,lambda).project();
//
//        dbSystem.operateOn(Collection).spatialBoundingBoxFilter(ColumnName...).min(3,4).max(7,8).project();
//        dbSystem.operateOn(Collection).spatialRangeFilter(ColumnName...).range(76).project();
//
//        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName,ColumnName).min(3,4).max(7,8).project();
//        dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName,ColumnName).range().project();
//
//        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName).min(3,4).max(7,8).project();
//        Dataset<Row> r = dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName).range(2).project();
//
//        dbSystem.disconnect();
//        SparkConf.load(r);
//
//
//        dbSystem.operateOn(Collection).filter()
//                .greaterThan(ColumnName,3)
//                .and()
//                .lessThan(ColumnName,100)
//                .or()
//                .equals(ColumnName,342)
//                .project();

    }

}