package gr.ds.unipi.noda.api.client.mongo;

import com.mongodb.MongoCredential;

public class MongoDBBuilderFactory {

    public MongoDBSys.Builder Builder(String username, String password, String database){
        return new MongoDBSys.Builder(username, password, database);
    }

    public MongoDBSys.Builder Builder(MongoCredential mongoCredential){
        return new MongoDBSys.Builder(mongoCredential);
    }

}
