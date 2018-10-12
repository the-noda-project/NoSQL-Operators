package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDbOperators {

    void scan(String column);

    void project(String... column);

    void filter();

}
