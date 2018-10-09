package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDocumentDbConnectivity extends NoSqlDbConnectivity {

    NoSqlDbOperators operateOnCollection();

}
