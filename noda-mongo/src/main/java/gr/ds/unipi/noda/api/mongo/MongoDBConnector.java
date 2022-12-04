package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MongoDBConnector implements NoSqlDbConnector<MongoClient> {

    private final List<Map.Entry<String, Integer>> addresses;
    //    private final MongoCredential mongoCredential;
    private MongoClientSettings mongoClientSettings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MongoDBConnector that = (MongoDBConnector) o;

        if (!mongoClientSettings.equals(that.mongoClientSettings)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mongoClientSettings.hashCode();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MongoDBConnector that = (MongoDBConnector) o;
//        return (addresses.containsAll(that.addresses) && addresses.size() == that.addresses.size()) &&
//                /*mongoCredential.equals(that.mongoCredential) &&*/
//                mongoClientSettings.equals(that.mongoClientSettings);
//    }
//
//    @Override
//    public int hashCode() {
//        int hashCode = 0;
//        for (Map.Entry<String, Integer> e : addresses) {
//            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
//        }
//        //hashCode = 31 * hashCode + mongoCredential.hashCode();
//        hashCode = 31 * hashCode + mongoClientSettings.hashCode();
//        return hashCode;
//    }

    private MongoDBConnector(List<Map.Entry<String, Integer>> addresses, /*MongoCredential mongoCredential,*/ MongoClientSettings mongoClientSettings) {
        this.addresses = addresses;
        //this.mongoCredential = mongoCredential;
        this.mongoClientSettings = mongoClientSettings;
    }

    @Override
    public MongoClient createConnection() {

        List<ServerAddress> serverAddressList = new ArrayList<>();
        addresses.forEach(address -> serverAddressList.add(new ServerAddress(address.getKey(), address.getValue())));

        mongoClientSettings = MongoClientSettings.builder(mongoClientSettings).applyToClusterSettings(builder -> builder.hosts(serverAddressList)).build();

        return MongoClients.create(mongoClientSettings);

//        if (addresses.size() == 1) {
//
//            MongoClientSettings.builder().builder().applyToClusterSettings(builder->builder.).credential()
//            return new MongoClient(new ServerAddress(addresses.get(0).getKey(), addresses.get(0).getValue()), mongoCredential, mongoClientOptions);
//        } else {
//            List<ServerAddress> servers = new ArrayList<>();
//            for (Map.Entry<String, Integer> entry : addresses) {
//                servers.add(new ServerAddress(entry.getKey(), entry.getValue()));
//            }
//            return new MongoClient(servers, mongoCredential, mongoClientOptions);
//        }
    }

    public static MongoDBConnector newMongoDBConnector(List<Map.Entry<String, Integer>> addresses,/*, MongoCredential mongoCredential,*/ MongoClientSettings mongoClientSettings) {
        return new MongoDBConnector(addresses, /*mongoCredential,*/ mongoClientSettings);
    }

    public String getMongoURIForSparkSession() {
        return "mongodb://" + getUsername() + ":" + getPassword() + "@" + getHost() + ":" + getPort(); //+ "/" + getDatabase() + ".";
    }

    public int getPort() {
        return addresses.get(0).getValue();
    }


    public String getHost() {
        return addresses.get(0).getKey();
    }


    public String getUsername() {
        return mongoClientSettings.getCredential().getUserName();
    }

    public String getPassword() {
        return String.valueOf(mongoClientSettings.getCredential().getPassword());
    }

    public String getDatabase() {
        return mongoClientSettings.getCredential().getSource();
    }

}
