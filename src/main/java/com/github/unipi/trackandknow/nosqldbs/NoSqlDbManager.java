package com.github.unipi.trackandknow.nosqldbs;

public class NoSqlDbManager<T> {

    private final NoSqlDb noSqlDb;
    private final T t;

    private NoSqlDbManager(T t, NoSqlDb noSqlDb){
        this.t = t;
        this.noSqlDb = noSqlDb;

    }

    public NoSqlDbOperators operateOn(String e){
        return noSqlDb.noSqlDbOperators(t,e);
    }

    public void disconnect(){
        noSqlDb.disconnect(t);
    }


    public static <T> NoSqlDbManager newNoSqlManager(T t, NoSqlDb noSqlDb){
        return new NoSqlDbManager(t,noSqlDb);
    }

}
