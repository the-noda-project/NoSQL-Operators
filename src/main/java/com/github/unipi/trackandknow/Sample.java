package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.connectivity.NoSqlDbSystem;

public class Sample {

    public static void main(String args[]){
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(27017).connect();

        System.out.println(noSqlDbSystem.operateOn("points").count());

        noSqlDbSystem.closeConnection();
    }
}
