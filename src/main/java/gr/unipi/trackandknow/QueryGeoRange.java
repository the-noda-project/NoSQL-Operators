package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

public class QueryGeoRange {

    public static void main(String args[]){

        rangeQuery("real","real", "real", 2.18,Integer.valueOf(args[0]));
        rangeQuery("synthetic1","synthetic1", "synthetic1", 27.165,Integer.valueOf(args[0]));
        rangeQuery("synthetic2","synthetic2", "synthetic2", 27.165,Integer.valueOf(args[0]));

    }

    private static void rangeQuery(String userName, String database, String password, double initialRadius, int i){

        System.out.println(userName);

        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleKm("location", Coordinates.newCoordinates(23.7613, 37.9864 ), initialRadius * i)).count();
            System.out.println(((System.currentTimeMillis()-start)/1000f) + " sec");
            System.out.println("Number of results: " + j);

        noSqlDbSystem3.closeConnection();

        System.out.println();

    }
}
