package gr.ds.unipi.noda.api.client.mongo;

import com.mongodb.MongoCredential;

public class MongoDBBuilderFactory {

    public MongoDBSystem.Builder Builder(String username, String password, String database){
        return new MongoDBSystem.Builder(username, password, database);
    }

    public MongoDBSystem.Builder Builder(MongoCredential mongoCredential){
        return new MongoDBSystem.Builder(mongoCredential);
    }

}
