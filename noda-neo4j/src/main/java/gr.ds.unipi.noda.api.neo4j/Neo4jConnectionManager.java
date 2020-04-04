package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.neo4j.driver.Driver;

final class Neo4jConnectionManager extends NoSqlDbConnectionManager<Driver> {

    private static final Neo4jConnectionManager INSTANCE = new Neo4jConnectionManager();

    private Neo4jConnectionManager() {

    }

    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            getConnections().get(noSqlDbConnector).close(); //close it with Neo4j library method - for example in MongoDB it is .close()
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            v.close(); //close it with Neo4j library method - for example in MongoDB it is .close()
        });
        getConnections().clear();
        return true;
    }

    public static Neo4jConnectionManager getInstance() {
        return INSTANCE;
    }

}
