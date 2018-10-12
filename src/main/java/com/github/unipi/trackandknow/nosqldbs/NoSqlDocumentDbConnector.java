package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDocumentDbConnector extends NoSqlDbConnector {

//    NoSqlDbOperators operateOnCollection();
    NoSqlDbManager getNoSqlDbManager();

}
