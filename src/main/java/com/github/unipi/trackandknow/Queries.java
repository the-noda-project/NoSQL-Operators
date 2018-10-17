package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.*;


public class Queries {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.104.92", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");

        long start = System.currentTimeMillis();
        //long d = m.count(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38)));
        long d = m.count(Filters.geoWithinBox("coordinates",0,0,1,1));

        System.out.println((System.currentTimeMillis()-start)/1000);
        System.out.println("d "+ d);

//        int count = 0;
//
//        while(d.iterator().hasNext()){
//            d.iterator().next();
//            count++;
//        }
//
//        System.out.println("Count "+count);


    }
}
