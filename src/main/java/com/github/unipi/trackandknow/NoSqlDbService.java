package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDb;
import com.github.unipi.trackandknow.nosqldbs.NoSqlDbConnection;

public class NoSqlDbService {

//    private final String host;
//    private final int port;
//    private final String database; // the name of the database in which the user is defined
//    private final String username; // the user name
//    private final String password; // the password as a character array

    public static class Builder {

        private final NoSqlDb nsdb;

        private String host;
        private int port;
        private String database; // the name of the database in which the user is defined
        private String username; // the user name
        private String password; // the password as a character array

        public Builder(NoSqlDb nsdb) {

            this.nsdb = nsdb;
            this.host = nsdb.getDefaultHost();
            this.port = nsdb.getDefaultPort();
            this.database = nsdb.getDefaultDatabase();
            this.username = nsdb.getDefaultUsername();
            this.password = nsdb.getDefaultPassword();

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

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public NoSqlDbConnection connect(){
            return nsdb.noSqlDbConnectivity(host, port, username, password, database);
        }

    }

//    private NoSqlDbService(Builder builder){
//        host = builder.host;
//        port = builder.port;
//        database = builder.database;
//        username = builder.username;
//        password = builder.password;
//    }

    public static Builder MongoDB(){
        return new NoSqlDbService.Builder(NoSqlDb.MONGODB);
    }

}