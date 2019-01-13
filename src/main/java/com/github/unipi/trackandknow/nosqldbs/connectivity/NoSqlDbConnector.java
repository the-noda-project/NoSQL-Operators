package com.github.unipi.trackandknow.nosqldbs.connectivity;

public interface NoSqlDbConnector<T> {

    T createConnection();

    int hashCode();

    boolean equals(Object o);

}
