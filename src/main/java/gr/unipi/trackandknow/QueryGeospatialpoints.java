package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.gte;
import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.lte;


public class QueryGeospatialpoints {
    public static void main(String[] args) throws ParseException {

        final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //final Date maxDate = sd.parse("2018-06-30 23:59:59.999");
        final Date maxDate = sd.parse("2017-12-31 23:59:59.999");
        final Date minDate = sd.parse("2017-06-29 00:00:00.000");

        int o = 0;

        if(Integer.valueOf(args[0])==0) {
            System.out.println("real");
            NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database("real").username("real").password("real").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                o = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.6682, 37.9477)),gte("date",minDate),lte("date",maxDate)).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            System.out.println("real count: "+o);
            noSqlDbSystem3.closeConnection();
            System.out.println();
        }

        if(Integer.valueOf(args[0])==1) {
            System.out.println();
            System.out.println("synthetic1");
            NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("localhost").database("synthetic1").username("synthetic1").password("synthetic1").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                o = noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.5500, 37.9262), Coordinates.newCoordinates(23.95, 38.30)),gte("date",minDate),lte("date",maxDate)).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            System.out.println("synthetic1 count: "+o);
            noSqlDbSystem2.closeConnection();
        }

        if(Integer.valueOf(args[0])==2) {
            System.out.println("synthetic2");
            NoSqlDbSystem noSqlDbSystem1 = NoSqlDbSystem.MongoDB().host("localhost").database("synthetic2").username("synthetic2").password("synthetic2").port(27017).build();
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                o = noSqlDbSystem1.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.5500, 37.9262), Coordinates.newCoordinates(23.95, 38.30)),gte("date",minDate),lte("date",maxDate)).count();
                System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            }
            System.out.println("synthetic2 count: "+o);
            noSqlDbSystem1.closeConnection();
        }


    }
}
