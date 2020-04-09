package gr.ds.unipi.noda.api.client.neo4j;

import org.neo4j.driver.AuthToken;

public class Neo4jBuilderFactory {

    public Neo4jSys.Builder Builder(String username, String password, String database){
        return new Neo4jSys.Builder(username, password, database);
    }

    public Neo4jSys.Builder Builder(AuthToken authToken){
        return new Neo4jSys.Builder(authToken);
    }
}
