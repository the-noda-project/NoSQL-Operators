package gr.unipi.trackandknow;

import gr.unipi.trackandknow.api.nosqldb.NoSqlDbOperators;
import gr.unipi.trackandknow.api.nosqldb.NoSqlDbSystem;
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
import java.util.Optional;

public class CodeComparison {

public static void main(String args[]){

    NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem
            .MongoDB().host("83.212.102.163")
            .database("test").username("user")
            .password("pass").port(28017).build();

    NoSqlDbOperators noSqlDbOp = noSqlDbSystem.operateOn("geoPoints");

    Optional<Double> max = noSqlDbOp.max("aField");

    if(max.isPresent()){
        double highestSalaryOptional = max.get();
    }


    int count = noSqlDbOp.count();

    noSqlDbSystem.closeConnection();


    MongoCredential credential = MongoCredential.createCredential("user", "test", "pass".toCharArray());
    MongoClientOptions options = MongoClientOptions.builder().build();
    MongoClient mongoClient = new MongoClient(new ServerAddress("83.212.102.163", 28017), credential, options);

    MongoCollection mongoCollection = mongoClient.getDatabase("test").getCollection("geoPoints");

    List<Bson> b1 = new ArrayList<>();
    b1.add(Document.parse("{ $group: { _id:null, max_val: { $max:\"$aField\"} } }"));

    MongoCursor<Document> cursor1 = (MongoCursor<Document>) mongoCollection.aggregate(b1).iterator();
    //int max =  cursor1.next().getInteger("max_val");

    cursor1.close();

    List<Bson> b2 = new ArrayList<>();
    b2.add(Document.parse("{ $count: \"totalRecords\" }"));

    MongoCursor<Document> cursor2 = (MongoCursor<Document>) mongoCollection.aggregate(b1).iterator();
    //int count =  cursor2.next().getInteger("totalRecords");

    cursor2.close();

    mongoClient.close();

}
}
