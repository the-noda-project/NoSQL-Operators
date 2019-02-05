package gr.unipi.trackandknow.api.nosqldb;

public interface NoSqlDbConnector<T> {

    T createConnection();

    int hashCode();

    boolean equals(Object o);

}
