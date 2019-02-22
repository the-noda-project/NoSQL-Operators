package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

import static com.mongodb.client.model.Filters.*;


public class QueryGeopointsWithIndex {
    public static void main(String[] args) {

//        NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(27017).build();
//
//        long start = System.currentTimeMillis();
//        System.out.println(noSqlDbSystem2.operateOn("points").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.6682, 37.9477))).count());
//        //System.out.println(noSqlDbSystem2.operateOn("points").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.9500, 38.1500))));
//
//
//        System.out.print("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);


//        NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("localhost").database("synthetic1").username("synthetic1").password("synthetic1").port(27017).build();
//        long start = System.currentTimeMillis();
//        System.out.println(noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.9500, 38.1500))).count());
//        System.out.print("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);


        if(Integer.valueOf(args[0])==0) {
            System.out.println("real");
            NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database("real").username("real").password("real").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.6682, 37.9477))).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            noSqlDbSystem3.closeConnection();
            System.out.println();
        }

        if(Integer.valueOf(args[0])==1) {
            System.out.println();
            System.out.println("synthetic1");
            NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("localhost").database("synthetic1").username("synthetic1").password("synthetic1").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.5500, 37.9262), Coordinates.newCoordinates(23.95, 38.30))).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            noSqlDbSystem2.closeConnection();
        }

        if(Integer.valueOf(args[0])==2) {
            System.out.println("synthetic2");
            NoSqlDbSystem noSqlDbSystem1 = NoSqlDbSystem.MongoDB().host("localhost").database("synthetic2").username("synthetic2").password("synthetic2").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                noSqlDbSystem1.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.5500, 37.9262), Coordinates.newCoordinates(23.95, 38.30))).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            noSqlDbSystem1.closeConnection();
        }


    }
}
