package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbManager;
import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoSqlDbServiceTest {

    @Test
    public void makeAConnection(){
        NoSqlDbManager manager = NoSqlDbService.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect()
                .getNoSqlDbManager();

        manager.operateOn("points").scan();

        manager.operateOn("collection").filter("aColumn",f->f>3).project("aColumn");

        NoSqlDbOperators operateOnSpecificCollection = manager.operateOn("otherCollection");

        operateOnSpecificCollection.scan();
        operateOnSpecificCollection.project("aColumn","bColumn");

        manager..disconnect();

        NoSqlDbService v = new NoSqlDbService();
        v.
    }

}