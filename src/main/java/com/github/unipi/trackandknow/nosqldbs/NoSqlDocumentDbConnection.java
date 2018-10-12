package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDocumentDbConnection extends NoSqlDbConnection {

//    NoSqlDbOperators operateOnCollection();
    NoSqlDbManager getNoSqlDbManager();

}
