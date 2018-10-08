package com.github.unipi.trackandknow;

public class NoSqlDb<? extends NoSqlDbConnectivity> {

    private final String host;
    private final int port;
    private final String database; // the name of the database in which the user is defined
    private final String username; // the user name
    private final char[] password; // the password as a character array
    private NoSqlDbConnectivity n =  n;

    public static class Builder {

        private String host = new ?.NoSqlDbOperators();
        private int port;
        private String database; // the name of the database in which the user is defined
        private String username; // the user name
        private char[] password; // the password as a character array

        public Builder() {


        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(char[] password) {
            this.password = password;
            return this;
        }

    }

    private NoSqlDb(Builder builder){
        host = builder.host;
        port = builder.port;
        database = builder.database;
        username = builder.username;
        password = builder.password;
    }

}
