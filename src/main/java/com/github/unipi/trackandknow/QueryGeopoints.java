package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;


public class QueryGeopoints {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
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

//        long d = m.countDocuments(f);

//        long d = m.countDocuments(and(f,and(and(and(gte("location.coordinates.0",21),gte("location.coordinates.1",35)),lte("location.coordinates.0",25)),lte("location.coordinates.1",38))));

        Polygon polygon = new Polygon(Arrays.asList(new Position(21, 35),new Position(25, 35),new Position(25, 38),new Position(21, 38),new Position(21, 35)));
        long d = m.countDocuments(Filters.geoWithin("location", polygon));

        //long d = m.countDocuments(Filters.nearSphere("location",23D,36.5D,166800D,0D));

        System.out.println("geoPoints collection");
        System.out.println("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);
        System.out.println("Number Of Records: "+ d);

        mongoClient.close();

    }

}
