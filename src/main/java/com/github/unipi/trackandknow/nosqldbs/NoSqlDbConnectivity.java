package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDbConnectivity {

    NoSqlDbConnectivity connect();

    void disconnect();

}
