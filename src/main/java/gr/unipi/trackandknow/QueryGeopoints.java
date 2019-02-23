package gr.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;


import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;


public class QueryGeopoints {
    public static void main(String[] args) {

        if(Integer.valueOf(args[0])==0) {
            MongoCredential credential1 = MongoCredential.createCredential("real", "real", "real".toCharArray());
            MongoClientOptions options1 = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
            MongoClient mongoClient1 = new MongoClient(new ServerAddress("localhost", 27017), credential1, options1);

            MongoCollection m1 = mongoClient1.getDatabase("real").getCollection("geoPoints");

            for (int i = 0; i < 3; i++) {
                long start1 = System.currentTimeMillis();

                long d1 = m1.countDocuments(and(and(and(gte("location.coordinates.0", 23.6266), gte("location.coordinates.1", 37.9262)), lte("location.coordinates.0", 23.6682)), lte("location.coordinates.1", 37.9477)));
                System.out.print("Time Elapsed: " + (System.currentTimeMillis() - start1) / 1000f);
                System.out.println("Number of docs" + d1);
            }
            mongoClient1.close();

        }

        if(Integer.valueOf(args[0])==1) {
            MongoCredential credential2 = MongoCredential.createCredential("synthetic1", "synthetic1", "synthetic1".toCharArray());
            MongoClientOptions options2 = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
            MongoClient mongoClient2 = new MongoClient(new ServerAddress("localhost", 27017), credential2, options2);

            MongoCollection m2 = mongoClient2.getDatabase("synthetic1").getCollection("geoPoints");

            for (int i = 0; i < 3; i++) {
                long start2 = System.currentTimeMillis();

                long d2 = m2.countDocuments(and(and(and(gte("location.coordinates.0", 23.5500), gte("location.coordinates.1", 37.9262)), lte("location.coordinates.0", 23.95)), lte("location.coordinates.1", 38.30)));
                System.out.print("Time Elapsed: " + (System.currentTimeMillis() - start2) / 1000f);
                System.out.println("Number of docs" + d2);
            }
            mongoClient2.close();

        }

        if(Integer.valueOf(args[0])==2) {

            MongoCredential credential3 = MongoCredential.createCredential("synthetic2", "synthetic2", "synthetic2".toCharArray());
            MongoClientOptions options3 = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
            MongoClient mongoClient3 = new MongoClient(new ServerAddress("localhost", 27017), credential3, options3);

            MongoCollection m3 = mongoClient3.getDatabase("synthetic2").getCollection("geoPoints");

            for (int i = 0; i < 3; i++) {
                long start3 = System.currentTimeMillis();

                long d3 = m3.countDocuments(and(and(and(gte("location.coordinates.0", 23.5500), gte("location.coordinates.1", 37.9262)), lte("location.coordinates.0", 23.95)), lte("location.coordinates.1", 38.30)));
                System.out.print("Time Elapsed: " + (System.currentTimeMillis() - start3) / 1000f);
                System.out.println("Number of docs" + d3);
            }
            mongoClient3.close();
        }
//        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
//        MongoClientOptions options = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
//        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 27017), credential, options);
//
//        MongoCollection m = mongoClient.getDatabase("test").getCollection("points");
//
//        long start = System.currentTimeMillis();
//
//        long d = m.countDocuments(and(and(and(gte("location.coordinates.0",23.6266),gte("location.coordinates.1",37.9262)),lte("location.coordinates.0",23.6682)),lte("location.coordinates.1",37.9477)));
//        System.out.print("Time Elapsed: "+(System.currentTimeMillis()-start)/1000);
//        System.out.println("Number of docs" + d);
//        mongoClient.close();

//        List<Bson> b = new ArrayList<>();
//        b.add(
//                Document.parse(
//
//                        //"{ $gte: [ {$arrayElemAt:['$location.coordinates',0]}, 25] }"
//
//
//
//                      "{ $match: { \"location.coordinates.0\": {$gte: 25} } " +
//                              "}"
//                )
//        );
//        b.add(
//                        Document.parse(
//                                "{ $count: \"counter\" "+
//                                        "}"
//                        )
//                );

//        MongoCursor<Document> cursor = m.aggregate(b).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }





//        Bson f = Filters.expr(
//
//                Document.parse(
//                      "{$lte:[ "+
//                        "{$sqrt:["+
//                          "{$add: ["+
//                                "{$pow: [" +
//
//
//                                "   {$subtract: [{$arrayElemAt:['$location.coordinates',0]}, 23]}" +
//                                ",2]}"+ ","+
//                                "{$pow: [" +
//                                "   {$subtract: [{$arrayElemAt:['$location.coordinates',1]}, 36.5]}" +
//                                ",2]}"+ "]}"+"]}"+",1.5]}"
//                )
//        );
//
//        long d = m.countDocuments(f);

//        long d = m.countDocuments(and(f,and(and(and(gte("location.coordinates.0",21),gte("location.coordinates.1",35)),lte("location.coordinates.0",25)),lte("location.coordinates.1",38))));

//        Polygon polygon = new Polygon(Arrays.asList(new Position(21, 35),new Position(25, 35),new Position(25, 38),new Position(21, 38),new Position(21, 35)));
//        long d = m.countDocuments(Filters.geoWithin("location", polygon));

        //long d = m.countDocuments(Filters.geoWithinCenterSphere("location",23,36.5,166.8/6378.1));
        //long d = m.countDocuments(Filters.nearSphere("location",23D,36.5D,166800D,0D));


//        Bson f = Filters.expr(
//                //Document.parse(
//                "{" +
//                        "location: {" +
//                        "     $near: {" +
//                        "       $geometry: {" +
//                        "          type: \"Point\" ," +
//                        "          coordinates: [ 23, 36.5 ]" +
//                        "       }," +
//                        "       $maxDistance: 16680," +
//                        "       $minDistance: 1" +
//                        "     }" +
//                        "   }" +
//                        "}"
//               // )
//        );

//        long d = m.countDocuments(f);

        //long d = m.countDocuments(Filters.geoWithinCenterSphere("coordinates",23,36.5,166.8/6378.1));
        //long d = m.countDocuments(Filters.geoWithinCenterSphere("location",23,36.5,55.6/6378.1));
//        Polygon polygon = new Polygon(Arrays.asList(new Position(22.5, 36), new Position(23, 36), new Position(23, 36.3), new Position(22.5, 36.3), new Position(22.5, 36)));
        //long d = m.countDocuments(Filters.geoWithin("location", polygon));
//        System.out.println(FilterOperators.lte("objectId", 0).getJsonStringBuilder());


        //long d = m.countDocuments(Document.parse(FilterOperators.or(inGeoRangeKm("location",23, 36.5,55.6),FilterOperators.lte("objectId",400)).getJsonString()));
//        long d = m.countDocuments(Document.parse(FilterOperators.eq("objectId", "15320_135320").getJsonStringBuilder().toString()));

        //System.out.println(inGeoBox("location",22.5, 36,23, 36.3));

//        System.out.println("geoPoints collection");
//        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - start) / 1000);
//        System.out.println("Number Of Records: " + d);

    }
}
