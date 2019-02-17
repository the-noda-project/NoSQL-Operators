package gr.unipi.trackandknow;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.model.Indexes;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;

import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.inGeoBox;

import gr.unipi.trackandknow.api.nosqldb.NoSqlDbOperators;

public class IndexConstruction {
        public static void main(String args[]) {

            constructIndex("synthetic2", "synthetic2", "synthetic2");

            constructIndex("synthetic1", "synthetic1", "synthetic1");

            constructIndex("real", "real", "real");

        }

        private static void constructIndex(String userName, String database, String password){
            MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
            MongoClientOptions options = MongoClientOptions.builder().build();
            MongoClient mc = new MongoClient(new ServerAddress("", 27010), credential, options);

            long t = System.currentTimeMillis();
            mc.getDatabase(database).getCollection("geoPoints").createIndex(Indexes.geo2dsphere("location"));
            System.out.println(database+" index: "+(System.currentTimeMillis()-t)/1000 +" sec");

            mc.close();
        }
    }
