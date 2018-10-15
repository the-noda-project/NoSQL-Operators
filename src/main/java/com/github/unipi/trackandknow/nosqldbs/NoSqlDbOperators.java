package com.github.unipi.trackandknow.nosqldbs;

import com.mongodb.Function;

public interface NoSqlDbOperators {


    void project();

    void project(String... column);

    NoSqlDbOperators filter();

    NoSqlDocumentDbConnector filter();

}
