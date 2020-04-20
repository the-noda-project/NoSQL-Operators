package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import javafx.util.Pair;
import org.apache.arrow.flatbuf.Bool;
import org.neo4j.driver.AuthToken;
import org.neo4j.driver.Config;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.net.ServerAddress;

import java.util.List;
import java.util.Objects;

public final class Neo4jConnector implements NoSqlDbConnector<Driver> {

    private final List<Pair<String,Integer>> addresses;
    private final AuthToken authToken;
    private final Config config;
    private String typeOfConnection;
    private Boolean encryptionWithoutLocalhost;


    private Neo4jConnector(List<Pair<String,Integer>> addresses, AuthToken authToken, Config config) {
        System.out.println("eimai edw???");
        this.addresses = addresses;
        this.authToken = authToken;
        this.config = config;
        System.out.println(addresses.get(0).getValue());
        System.out.println(authToken);
    }

    @Override
    public Driver createConnection() {
        System.out.println("eimai edw 2");
        //typeOfConnection => neo4j means server connection
        //typeOfConnection => bolt means localhost
        StringBuilder sb = new StringBuilder();
        encryptionWithoutLocalhost = true;
        String firstHost = addresses.get(0).getKey();
        String firstPort = addresses.get(0).getValue().toString();

        System.out.println("eimai edw 3");

        for (Pair<String, Integer> address : addresses) {
            if (address.getKey().equals("localhost") || address.getKey().equals("127.0.0.1")) {
                encryptionWithoutLocalhost = false;
                break;
            }
        }

        List<ServerAddress> serverAddresses = null;

        for (Pair<String, Integer> address : addresses) {
//            sb.append(ServerAddress.of(address.getKey(), address.getValue() ));
//            sb.append(address.getKey()).append(":").append(address.getValue()).append(",");
            if(address.getKey() != addresses.get(0).getKey() && address.getValue() != addresses.get(0).getValue()) {
                serverAddresses.add(ServerAddress.of(address.getKey(), address.getValue()));
            }
        }

//        Config config = Config.builder().withResolver( address -> new HashSet( Arrays.asList( addresses ) ) ).build();

        if(encryptionWithoutLocalhost == true) {
            Config config = Config.builder().withEncryption().build();
        }


//        config.builder().withResolver( address -> new HashSet( Arrays.asList( addresses ) ) ).build();

        System.out.println("bolt://" + firstHost + ":" + firstPort);


        return GraphDatabase.driver(  "bolt://" + firstHost + ":" + firstPort, authToken, config);
    }

    public static Neo4jConnector newNeo4jConnector(List<Pair<String,Integer>> addresses, AuthToken authToken, Config config) {
        return new Neo4jConnector(addresses, authToken, config);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neo4jConnector that = (Neo4jConnector) o;
        return addresses.equals(that.addresses) &&
                authToken.equals(that.authToken) &&
                config.equals(that.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, authToken, config);
    }
}
