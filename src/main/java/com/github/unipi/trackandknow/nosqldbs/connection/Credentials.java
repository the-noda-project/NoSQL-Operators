package com.github.unipi.trackandknow.nosqldbs.connection;

public class Credentials {

    private String host;
    private int port;
    private String database; // the name of the database in which the user is defined
    private String username; // the user name
    private String password;


    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
