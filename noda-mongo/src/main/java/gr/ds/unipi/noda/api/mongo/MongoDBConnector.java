package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MongoDBConnector implements NoSqlDbConnector<MongoClient> {

    private final List<Map.Entry<String, Integer>> addresses;
    private final MongoCredential mongoCredential;
    private final MongoClientOptions mongoClientOptions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoDBConnector that = (MongoDBConnector) o;
        return (addresses.containsAll(that.addresses) && addresses.size() == that.addresses.size()) &&
                mongoCredential.equals(that.mongoCredential) &&
                mongoClientOptions.equals(that.mongoClientOptions);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (Map.Entry<String, Integer> e : addresses) {
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        hashCode = 31 * hashCode + mongoCredential.hashCode();
        hashCode = 31 * hashCode + mongoClientOptions.hashCode();

        return hashCode;
    }

    private MongoDBConnector(List<Map.Entry<String, Integer>> addresses, MongoCredential mongoCredential, MongoClientOptions mongoClientOptions) {
        this.addresses = addresses;
        this.mongoCredential = mongoCredential;
        this.mongoClientOptions = mongoClientOptions;
    }

    @Override
    public MongoClient createConnection() {
        if (addresses.size() == 1) {
            return new MongoClient(new ServerAddress(addresses.get(0).getKey(), addresses.get(0).getValue()), mongoCredential, mongoClientOptions);
        } else {
            List<ServerAddress> servers = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : addresses) {
                servers.add(new ServerAddress(entry.getKey(), entry.getValue()));
            }
            return new MongoClient(servers, mongoCredential, mongoClientOptions);
        }
    }

    public static MongoDBConnector newMongoDBConnector(List<Map.Entry<String, Integer>> addresses, MongoCredential mongoCredential, MongoClientOptions mongoClientOptions) {
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

    public String getPassword() {
        return String.valueOf(mongoCredential.getPassword());
    }


    public String getDatabase() {
        return mongoCredential.getSource();
    }

}
