package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;


public class QueryPoints {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");

        long start = System.currentTimeMillis();

//        long d = m.countDocuments(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38)));

//        Bson f = Filters.expr(
//
//                Document.parse(
//                      "{$lte:[ "+
//                        "{$sqrt:["+
//                          "{$add: ["+
//                                "{$pow: [" +
//
//
//                                "   {$subtract: [{$arrayElemAt:['$coordinates',0]}, 23]}" +
//                                ",2]}"+ ","+
//                                "{$pow: [" +
//                                "   {$subtract: [{$arrayElemAt:['$coordinates',1]}, 36.5]}" +
//                                ",2]}"+ "]}"+"]}"+",1.5]}"
//                )
//        );

//        long d = m.countDocuments(f);

//        long d = m.countDocuments(and(f,and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38))));


//        long d = m.countDocuments(Filters.geoWithinBox("coordinates",21,35,25,38));


                Bson f = Filters.expr(

                      "{coordinates: {\n" +
                              "  $near: [ 23, 36.5 ],\n" +
                              "  $minDistance: 0,\n" +
                              "  $maxDistance: 1.5\n" +
                              "}}"

        );


        //long d = m.countDocuments(f);

        long d = m.countDocuments(Filters.near("coordinates",23,36.5,new Double(2),new Double(0)));

        System.out.println("points collection");
        System.out.println("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);
        System.out.println("Number Of Records: "+ d);

        mongoClient.close();

    }
}
