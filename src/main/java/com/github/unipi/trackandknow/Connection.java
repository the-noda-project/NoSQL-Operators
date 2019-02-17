package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Connection {
    public static void main(String args[]){

        MongoCredential credential = MongoCredential.createCredential("christos.doulkeridis1", "dataset1", "Yhx8ypJ,".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoClient mc = new MongoClient(new ServerAddress("93.46.200.55", 27010), credential, options);

        mc.getDatabase("dataset1").listCollections().iterator().forEachRemaining(v -> System.out.println(v));
    }
}
