package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import com.sun.tools.javac.util.List;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;


public class Queries {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.104.92", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("geoPoints");

        long start = System.currentTimeMillis();

        //long d = m.count(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38)));
        //long d = m.count(Filters.geoWithinBox("coordinates",0,0,1,1));

        Polygon polygon = new Polygon(List.of(new Position(0, 0),new Position(1, 0),new Position(1, 1),new Position(0, 1),new Position(0, 0)));
        long d = m.count(Filters.geoWithin("location.coordinates", polygon));

        System.out.println((System.currentTimeMillis()-start)/1000);
        System.out.println("d "+ d);


        mongoClient.close();
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