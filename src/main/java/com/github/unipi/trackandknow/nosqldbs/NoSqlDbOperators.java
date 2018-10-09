package com.github.unipi.trackandknow.nosqldbs;

public interface NoSqlDbOperators<T> {

    T scan(String column);

}
