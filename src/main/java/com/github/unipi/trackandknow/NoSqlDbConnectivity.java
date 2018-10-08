package com.github.unipi.trackandknow;

public interface NoSqlDbConnectivity {

    NoSqlDbOperators connect();

    void disconnect();

    default String getDefaultHost(){
        return "localhost";
    }

    int getDefaultPort();

    String getDefaultDatabase(); // the name of the database in which the user is defined

    String getDefaultUsername(); // the user name

    String getDefaultPassword(); // the password as a character array

}
