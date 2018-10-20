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

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;


public class Queries {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.237.147", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");

        long start = System.currentTimeMillis();

        long d = m.count(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38)));
        //long d = m.count(Filters.geoWithinBox("coordinates",0,0,1,1));
        //long d = m.count(Filters.geoWithinCenterSphere("coordinates",0.5,0.5,0.3));

        //Polygon polygon = new Polygon(Arrays.asList(new Position(21.5, 38),new Position(22, 38),new Position(22, 38.5),new Position(21.5, 38.5),new Position(21.5, 38)));
        //long d = m.count(Filters.geoWithin("location.coordinates", polygon));

        System.out.println("geopoints");
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
