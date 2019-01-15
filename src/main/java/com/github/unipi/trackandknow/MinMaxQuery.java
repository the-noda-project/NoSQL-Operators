package com.github.unipi.trackandknow;

public class MinMaxQuery {

    public static void main(String args[]) {

//        MongoCredential credential = MongoCredential.createCredential("myUserAdmin", "test", "abc123".toCharArray());
//        MongoClientOptions options = MongoClientOptions.builder().maxConnectionIdleTime(90000).build();
//        MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 28017), credential, options);
//
//        MongoCollection m = mongoClient.getDatabase("test").getCollection("geoPoints");
//
//        List<Bson> b = new ArrayList<>();
//        b.add(                   Document.parse(
//                "{ $group:\n" +
//                "         {\n" +
//                "           _id: \"null\",\n" +
//                "           maxLon: { $max: {$arrayElemAt:['$location.coordinates',0]} }\n" +
//                "           maxLat: { $max: {$arrayElemAt:['$location.coordinates',1]} }\n" +
//                "           minLon: { $min: {$arrayElemAt:['$location.coordinates',0]} }\n" +
//                "           minLat: { $min: {$arrayElemAt:['$location.coordinates',1]} }\n" +
//                "         } }"));
//
//        MongoCursor<Document> cursor = m.aggregate(b).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }

        StringBuilder sb = new StringBuilder();
        sb.append("eu");
        sb.append(sb.append(sb));

        System.out.println(sb.toString());

    }
}
