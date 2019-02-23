package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryGeospatialRange {

    public static void main(String args[]) throws Exception {


        final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //final Date maxDate = sd.parse("2018-06-30 23:59:59.999");
        Date maxDate =null;
        final Date minDate = sd.parse("2017-06-29 00:00:00.000");

        if(Integer.valueOf(args[1])==1){
            maxDate = sd.parse("2017-09-30 23:59:59.999");
        }
        if(Integer.valueOf(args[1])==2){
            maxDate = sd.parse("2017-12-31 23:59:59.999");
        }
        if(Integer.valueOf(args[1])==4){
            maxDate = sd.parse("2018-03-31 23:59:59.999");
        }
        if(Integer.valueOf(args[1])==8){
            maxDate = sd.parse("2018-06-30 23:59:59.999");
        }

        if(maxDate==null){
            throw new Exception("maxDate is null");
        }

        if(Integer.valueOf(args[0])==0){
                rangeQuery("real", "real", "real", 2.18, Integer.valueOf(args[1]),minDate, maxDate);
        }
        if(Integer.valueOf(args[0])==1) {
                rangeQuery("synthetic1", "synthetic1", "synthetic1", 27.165, Integer.valueOf(args[1]),minDate, maxDate);
        }
        if(Integer.valueOf(args[0])==2) {
                rangeQuery("synthetic2", "synthetic2", "synthetic2", 27.165, Integer.valueOf(args[1]),minDate, maxDate);
        }
    }

    private static void rangeQuery(String userName, String database, String password, double initialRadius, int o,Date minDate,Date maxDate){

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
