package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Connection {
    public static void main(String args[]){

        MongoCredential credential = MongoCredential.createCredential("christos.doulkeridis2", "admin", "D1h0uJFX".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoClient mc = new MongoClient(new ServerAddress("93.46.200.55", 27017), credential, options);

        mc.listDatabaseNames().iterator().forEachRemaining(v-> System.out.println(v.toString()));

        mc.close();
    }
}
