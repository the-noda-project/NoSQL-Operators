package gr.unipi.noda.api.core.nosqldb;

public interface NoSqlDbConnector<T> {

    T createConnection();

    int hashCode();

    boolean equals(Object o);

}
