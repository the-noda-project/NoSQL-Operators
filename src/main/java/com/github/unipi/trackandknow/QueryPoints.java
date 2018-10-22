package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;


public class QueryPoints {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().maxConnectionIdleTime(100000)/*.sslEnabled(true)*/.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");

        long start = System.currentTimeMillis();

        //long d = m.count(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38)));

//        Bson f = Filters.expr(
//
//                Document.parse(
//                      "{$gt:[ "+
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
//
//        long d = m.count(and(f,and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38))));


        //long d = m.count(Filters.geoWithinBox("coordinates",21,35,25,38));



        long d = m.count(Filters.nearSphere("coordinates",23D,36.5D,1.5D,0D));

        System.out.println("points");
        System.out.println((System.currentTimeMillis()-start)/1000);
        System.out.println("d "+ d);

        mongoClient.close();

    }
}
