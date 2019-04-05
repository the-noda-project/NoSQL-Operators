package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

public class SmallQuery {
    public static void main(String args[]){

        if(Integer.valueOf(args[0])==0){
            rangeQuery1("real", "real", "real");
        }
        if(Integer.valueOf(args[0])==1) {
            rangeQuery2("synthetic1", "synthetic1", "synthetic1");
        }
        if(Integer.valueOf(args[0])==2) {
            rangeQuery2("synthetic2", "synthetic2", "synthetic2");
        }
    }

    private static void rangeQuery1(String userName, String database, String password){

        System.out.println(userName);
        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(25.751467, 35.023487), 0.02)).count();
            System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            System.out.println("Number of results: " + j);
        }
        noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(25.751467,35.023487), 0.02)).printScreen();
        noSqlDbSystem3.closeConnection();
        System.out.println();
    }

    private static void rangeQuery2(String userName, String database, String password){

        System.out.println(userName);
        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(22.317873,38.565775), 0.02)).count();
            System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            System.out.println("Number of results: " + j);
        }
        noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(22.317873,38.565775), 0.02)).printScreen();
        noSqlDbSystem3.closeConnection();
        System.out.println();
    }
}
