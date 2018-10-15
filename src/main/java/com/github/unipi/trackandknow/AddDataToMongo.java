package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;


public class QueryMongo {
    public static void main(String[] args){

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "points", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.104.92", 27017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");

        m.find(and(and(and(gte("coordinates.0",21),gte("coordinates.1",35)),lte("coordinates.0",25)),lte("coordinates.1",38))).;



    }
}
