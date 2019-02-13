package gr.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import gr.unipi.trackandknow.api.filterOperator.FilterOperators;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;

import static com.mongodb.client.model.Filters.*;


public class QueryGeopointsWithIndex {
    public static void main(String[] args) {

        NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).build();

        long start = System.currentTimeMillis();
        System.out.println(noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoBox("location", Coordinates.newCoordinates(23.6266, 37.9262), Coordinates.newCoordinates(23.6682, 37.9477))).count());

        System.out.print("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);

    }
}
