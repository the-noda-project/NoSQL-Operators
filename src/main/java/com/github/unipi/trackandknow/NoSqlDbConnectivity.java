package com.github.unipi.trackandknow;

public interface NoSqlDbConnectivity {

    NoSqlDbOperators connect();

    void disconnect();
}
