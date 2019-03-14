package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.gte;
import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.lte;

public class SmallGeoQuery {
    public static void main(String args[]) throws ParseException {
        final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        final Date minDate1 = sd.parse("2018-02-22 08:55:52.000");
        final Date maxDate1 = sd.parse("2018-02-22 08:55:54.000");

        final Date minDate2 = sd.parse("2018-04-30 18:49:49.000");
        final Date maxDate2 = sd.parse("2018-04-30 18:49:51.000");

        if(Integer.valueOf(args[0])==0){
            rangeQuery1("real", "real", "real", minDate1, maxDate1);
        }
        if(Integer.valueOf(args[0])==1) {
            rangeQuery2("synthetic1", "synthetic1", "synthetic1", minDate2, maxDate2);
        }
        if(Integer.valueOf(args[0])==2) {
            rangeQuery2("synthetic2", "synthetic2", "synthetic2", minDate2, maxDate2);
        }
    }

    private static void rangeQuery1(String userName, String database, String password, Date minDate, Date maxDate){

        System.out.println(userName);
        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(25.751467,35.023487), 0.02),gte("date",minDate),lte("date",maxDate)).count();
            System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            System.out.println("Number of results: " + j);
        }
        noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(25.751467,35.023487), 0.02),gte("date",minDate),lte("date",maxDate)).printScreen();
        noSqlDbSystem3.closeConnection();
        System.out.println();
    }

    private static void rangeQuery2(String userName, String database, String password, Date minDate, Date maxDate){

        System.out.println(userName);
        NoSqlDbSystem noSqlDbSystem3 = NoSqlDbSystem.MongoDB().host("localhost").database(database).username(userName).password(password).port(27017).build();

        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            int j = noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(22.317873,38.565775), 0.02),gte("date",minDate),lte("date",maxDate)).count();
            System.out.println(((System.currentTimeMillis() - start) / 1000f) + " sec");
            System.out.println("Number of results: " + j);
        }
        noSqlDbSystem3.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location", Coordinates.newCoordinates(22.317873,38.565775), 0.02),gte("date",minDate),lte("date",maxDate)).printScreen();
        noSqlDbSystem3.closeConnection();
        System.out.println();
    }
}
