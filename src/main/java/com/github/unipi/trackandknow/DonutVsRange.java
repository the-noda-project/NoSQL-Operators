package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class DonutVsRange {
    public static void main(String args[]) {

        double longitude = 23f;
        double latitude = 36.5f;
        int radius2 = 45000;
        double radius1 = (radius2 / 1000f) / 6378.1f;
        System.out.println(radius1);

        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 28017), credential, options);

        MongoCollection m = mongoClient.getDatabase("test").getCollection("geoPoints");


        List<Bson> b1 = new ArrayList<>();
        b1.add(Document.parse(
                "{ $match: { \"location\": { $geoWithin : { $centerSphere : [ [" + longitude + ", " + latitude + "], " + radius1 + " ] } } } }"));
        b1.add(Document.parse("    {\n" +
                "      $count: \"passing_scores\"\n" +
                "    }"));

        long t1 = System.currentTimeMillis();
        MongoCursor<Document> cursor = m.aggregate(b1).iterator();

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        System.out.println("Calculation Time: " + (System.currentTimeMillis() - t1));

        mongoClient.close();


        mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 28017), credential, options);
        m = mongoClient.getDatabase("test").getCollection("geoPoints");


        List<Bson> b2 = new ArrayList<>();

        b2.add(Document.parse("    {\n" +
                "      $count: \"passing_scores\"\n" +
                "    }"));

//        b2.add(Document.parse(
//                "   {\n" +
//                        "     $geoNear: {\n" +
//                        "        near: { type: \"Point\", coordinates: [ "+longitude+", "+latitude+" ] },\n" +
//                        "        distanceField: \"dist.calculated\",\n" +
//                        "        maxDistance: "+radius2+",\n" +
//                        "        minDistance: "+0+",\n" +
//                        "        limit: 990000,\n" +
//                        //"        includeLocs: \"dist.location\",\n" +
//                        "        spherical: true\n" +
//                        "     } }"));

        b2.add(Document.parse(
                " { $match:  { location: {" +
                        "  $near: {\n" +

                        "        $geometry: { type: \"Point\", coordinates: [ " + longitude + ", " + latitude + " ] },\n" +
                        "        $maxDistance: " + radius2 + ",\n" +
                        "        $minDistance: " + 0 + ",\n" +

                        " } } } }"));


        t1 = System.currentTimeMillis();
        cursor = m.aggregate(b2).iterator();

        try {
            while (cursor.hasNext()) {

                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        //System.out.println(i);
        System.out.println("Calculation Time: " + (System.currentTimeMillis() - t1));

        mongoClient.close();


    }
}
