package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperators;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;

import java.util.Arrays;

import static com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperators.inGeoBox;
import static com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperators.inGeoRangeKm;


public class QueryGeopoints {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 28017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("geoPoints");


        long start = System.currentTimeMillis();

//        long d = m.countDocuments(and(and(and(gte("location.coordinates.0",21),gte("location.coordinates.1",35)),lte("location.coordinates.0",25)),lte("location.coordinates.1",38)));

//        Bson f = Filters.expr(
//
//                Document.parse(
//                      "{$lte:[ "+
//                        "{$sqrt:["+
//                          "{$add: ["+
//                                "{$pow: [" +
//
//
//                                "   {$subtract: [{$arrayElemAt:['$location.coordinates',0]}, 23]}" +
//                                ",2]}"+ ","+
//                                "{$pow: [" +
//                                "   {$subtract: [{$arrayElemAt:['$location.coordinates',1]}, 36.5]}" +
//                                ",2]}"+ "]}"+"]}"+",1.5]}"
//                )
//        );
//
//        long d = m.countDocuments(f);

//        long d = m.countDocuments(and(f,and(and(and(gte("location.coordinates.0",21),gte("location.coordinates.1",35)),lte("location.coordinates.0",25)),lte("location.coordinates.1",38))));

//        Polygon polygon = new Polygon(Arrays.asList(new Position(21, 35),new Position(25, 35),new Position(25, 38),new Position(21, 38),new Position(21, 35)));
//        long d = m.countDocuments(Filters.geoWithin("location", polygon));

        //long d = m.countDocuments(Filters.geoWithinCenterSphere("location",23,36.5,166.8/6378.1));
        //long d = m.countDocuments(Filters.nearSphere("location",23D,36.5D,166800D,0D));


//        Bson f = Filters.expr(
//                //Document.parse(
//                "{" +
//                        "location: {" +
//                        "     $near: {" +
//                        "       $geometry: {" +
//                        "          type: \"Point\" ," +
//                        "          coordinates: [ 23, 36.5 ]" +
//                        "       }," +
//                        "       $maxDistance: 16680," +
//                        "       $minDistance: 1" +
//                        "     }" +
//                        "   }" +
//                        "}"
//               // )
//        );

//        long d = m.countDocuments(f);

        //long d = m.countDocuments(Filters.geoWithinCenterSphere("coordinates",23,36.5,166.8/6378.1));
        //long d = m.countDocuments(Filters.geoWithinCenterSphere("location",23,36.5,55.6/6378.1));
        Polygon polygon = new Polygon(Arrays.asList(new Position(22.5, 36),new Position(23, 36),new Position(23, 36.3),new Position(22.5, 36.3),new Position(22.5, 36)));
        //long d = m.countDocuments(Filters.geoWithin("location", polygon));
        System.out.println(FilterOperators.lte("objectId",0).getJsonString());


        //long d = m.countDocuments(Document.parse(FilterOperators.or(inGeoRangeKm("location",23, 36.5,55.6),FilterOperators.lte("objectId",400)).getJsonString()));
        long d = m.countDocuments(Document.parse(FilterOperators.eq("objectId","15320_135320").getJsonString()));

        //System.out.println(inGeoBox("location",22.5, 36,23, 36.3));

        System.out.println("geoPoints collection");
        System.out.println("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);
        System.out.println("Number Of Records: "+ d);

        mongoClient.close();

    }
}
