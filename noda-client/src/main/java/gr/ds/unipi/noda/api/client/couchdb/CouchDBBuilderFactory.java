package gr.ds.unipi.noda.api.client.couchdb;

public class CouchDBBuilderFactory {
    public CouchDBSystem.Builder Builder(String username, String password, String database) {
        return new CouchDBSystem.Builder(username, password, database);
    }
}
