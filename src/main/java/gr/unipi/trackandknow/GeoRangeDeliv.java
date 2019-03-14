package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

public class GeoRangeDeliv {

    public static void main(String args[]){

        if(Integer.valueOf(args[0])==0){
                rangeQuery("real", "real", "real", 2.18, Double.valueOf(args[1]));
        }
    }

    private static void rangeQuery(String userName, String database, String password, double initialRadius, double o){

        System.out.println(userName);

        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleKm("location", Coordinates.newCoordinates(23.7613, 37.9864), initialRadius * o)).count();
            System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            System.out.println("Number of results: " + j);
        }

        noSqlDbSystem3.closeConnection();

        System.out.println();

    }
}
