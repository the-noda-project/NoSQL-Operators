package gr.ds.unipi.noda.api.client.neo4j;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.neo4j.Neo4jConnectionFactory;
import gr.ds.unipi.noda.api.neo4j.Neo4jConnector;
import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Config;

public class Neo4JSystem extends NoSqlDbSystem {

    private final Neo4jConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 7687;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {

        private final AuthToken authToken;

        private Config config = Config.defaultConfig();

        @Override
        public NoSqlDbSystem build() {
            return new Neo4JSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Builder config(Config config) {
            this.config = config;
            return this;
        }

        public Builder(AuthToken authToken) {
            this.authToken = authToken;
        }

        public Builder(String username, String password, String database) {
            this.authToken = AuthTokens.basic(username, password, database);
        }

    }

    private Neo4JSystem(Builder builder) {
        super(builder, new Neo4jConnectionFactory());
        connector = Neo4jConnector.newNeo4jConnector(getAddresses(), builder.authToken, builder.config);
    }
}
