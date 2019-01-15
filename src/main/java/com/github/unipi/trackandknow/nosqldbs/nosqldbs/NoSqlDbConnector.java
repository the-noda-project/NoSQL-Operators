package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

public interface NoSqlDbConnector<T> {

    T createConnection();

    int hashCode();

    boolean equals(Object o);

}
