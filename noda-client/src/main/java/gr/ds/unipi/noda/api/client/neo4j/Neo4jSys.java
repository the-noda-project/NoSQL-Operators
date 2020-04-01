package gr.ds.unipi.noda.api.client.neo4j;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.neo4j.Neo4jConnectionFactory;
import gr.ds.unipi.noda.api.neo4j.Neo4jConnector;
import org.neo4j.driver.Config;

public class Neo4jSys extends NoSqlDbSys{

    private /*final*/ Neo4jConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{

        private final String username;
        private final String password;
        private final String database;

        private Config config = Config.defaultConfig();

        @Override
        public NoSqlDbSys build() {
            return new Neo4jSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Builder config(Config config){
            this.config = config;
            return this;
        }

        public Builder(String username, String password, String database){
            this.username = username;
            this.password = password;
            this.database = database;
        }

    }

    private Neo4jSys(Builder builder) {
        super(builder, new Neo4jConnectionFactory());
        //connector = Neo4jConnector.newNeo4jConnector(getAddresses(),builder.username,builder.password,builder.database,builder.config);
    }
}
