package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import javafx.util.Pair;

import java.util.*;

public final class MongoDBConnector implements NoSqlDbConnector<MongoClient> {

    private final List<Pair<String,Integer>> addresses;
    private final MongoCredential mongoCredential;
    private final MongoClientOptions mongoClientOptions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoDBConnector that = (MongoDBConnector) o;
        return (addresses.containsAll(that.addresses) && addresses.size()==that.addresses.size()) &&
                mongoCredential.equals(that.mongoCredential) &&
                mongoClientOptions.equals(that.mongoClientOptions);
    }

    @Override
    public int hashCode() {
        int hashCode;
        for(Pair<String,Integer> e : addresses){
            hashCode = 31*hashCode()+(e==null ?0:e.hashCode());
        }
        hashCode = 31*hashCode()+ mongoCredential.hashCode();
        hashCode = 31*hashCode()+mongoClientOptions.hashCode();

        return hashCode;
    }

    private MongoDBConnector(List<Pair<String,Integer>> addresses, MongoCredential mongoCredential, MongoClientOptions mongoClientOptions) {
        this.addresses = addresses;
        this.mongoCredential = mongoCredential;
        this.mongoClientOptions = mongoClientOptions;
    }

    @Override
    public MongoClient createConnection() {
        if(addresses.size()==1){
            return new MongoClient(new ServerAddress(addresses.get(0).getKey(), addresses.get(0).getValue()), mongoCredential, mongoClientOptions);
        }
        else{
            List servers = Arrays.asList();
            for(Pair<String,Integer> pair : addresses){
                servers.add(new ServerAddress(pair.getKey(),pair.getValue()));
            }
            return new MongoClient(servers, mongoCredential, mongoClientOptions);
        }
    }

    public static MongoDBConnector newMongoDBConnector(List<Pair<String,Integer>> addresses, MongoCredential mongoCredential, MongoClientOptions mongoClientOptions) {
        return new MongoDBConnector(addresses, mongoCredential, mongoClientOptions);
    }

    public String getMongoURIForSparkSession() {
        return "mongodb://" + getUsername() + ":" + getPassword() + "@" + getHost() + ":" + getPort() + "/" + getDatabase() + ".";
    }

    public int getPort() {
        return addresses.get(0).getValue();
    }


    public String getHost() {
        return addresses.get(0).getKey();
    }


    public String getUsername() {
        return mongoCredential.getUserName();
    }

    public String getPassword() { return mongoCredential.getPassword().toString(); }


    public String getDatabase() {
        return mongoCredential.getSource();
    }

}
