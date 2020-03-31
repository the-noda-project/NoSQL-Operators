package gr.ds.unipi.noda.api.client.mongo;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.mongo.MongoDBConnectionFactory;
import gr.ds.unipi.noda.api.mongo.MongoDBConnector;

public class MongoDBSys extends NoSqlDbSys {

    private final MongoDBConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{

        private final MongoCredential mongoCredential;
        private MongoClientOptions mongoClientOptions = MongoClientOptions.builder().build();

        public Builder(MongoCredential mongoCredential){
            this.mongoCredential = mongoCredential;
        }

        public Builder(String username, String password, String database){
            this.mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());
        }

        public Builder mongoClientOptions(MongoClientOptions mongoClientOptions){
            this.mongoClientOptions = mongoClientOptions;
            return this;
        }

        @Override
        public NoSqlDbSys build() {
            return new MongoDBSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private MongoDBSys(Builder builder) {
        super(builder, new MongoDBConnectionFactory());
        connector = MongoDBConnector.newMongoDBConnector(addresses, builder.mongoCredential, builder.mongoClientOptions);
    }

}
