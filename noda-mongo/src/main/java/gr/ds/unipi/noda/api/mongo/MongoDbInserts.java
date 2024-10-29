package gr.ds.unipi.noda.api.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MongoDbInserts extends NoSqlDbInserts {
    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final List<Document> stagesList;
    private final String database;

    private MongoDbInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        this.stagesList = Collections.emptyList();
        MongoDBConnector mongoDBConnector = ((MongoDBConnector) noSqlDbConnector);
        database = mongoDBConnector.getDatabase();
    }

    private String getDatabase() {
        return database;
    }

    private MongoDbInserts(MongoDbInserts self, List<Document> stagesList) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.stagesList = stagesList;
        this.database = self.getDatabase();
    }

    public static MongoDbInserts newMongoDbInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        return new MongoDbInserts(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        if (stagesList.isEmpty()) {
            return this;
        }

        MongoClient connectionManager = mongoDBConnectionManager.getConnection(getNoSqlDbConnector());
        MongoDatabase db = connectionManager.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(getDataCollection());

        long count = collection.countDocuments();
        FindIterable<Document> documents = collection.find();

        try {
            collection.insertMany(stagesList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MongoDbInserts(this, Collections.emptyList());
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        List<Document> newDocuments = new ArrayList<>(this.stagesList);

        Map<String, Object> documentMap = java.util.stream.Stream.concat(java.util.stream.Stream.of(fv), Stream.of(fvs))
                .collect(Collectors.toMap(FieldValue::getField, FieldValue::getValue));

        Document document = new Document(documentMap);
        newDocuments.add(document);

        return new MongoDbInserts(this, newDocuments);
    }
}