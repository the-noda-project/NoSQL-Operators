package gr.ds.unipi.noda.api.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoDbDeletes extends NoSqlDbDeletes {
    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final String database;
    private final List<DeleteStage> stagesList;

    protected MongoDbDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        this.stagesList = Collections.emptyList();
        MongoDBConnector mongoDBConnector = ((MongoDBConnector) noSqlDbConnector);
        database = mongoDBConnector.getDatabase();
    }

    private MongoDbDeletes(MongoDbDeletes self, List<DeleteStage> stagesList) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.stagesList = stagesList;
        this.database = self.getDatabase();
    }

    private String getDatabase() {
        return database;
    }

    @Override
    public NoSqlDbDeletes flush() {
        if (stagesList.isEmpty())
            return this;

        MongoClient connectionManager = mongoDBConnectionManager.getConnection(getNoSqlDbConnector());
        MongoDatabase db = connectionManager.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(getDataCollection());

        for (DeleteStage stage : stagesList) {
            collection.deleteMany(stage.getFilter());
        }

        return new MongoDbDeletes(this, Collections.emptyList());
    }

    @Override
    public NoSqlDbDeletes delete(String... fields) {
        return null;
    }


    @Override
    public NoSqlDbDeletes delete(FilterOperator filterOperator, String... fields) {
        List<DeleteStage> newStagesList = new ArrayList<>(this.stagesList);

        Document filter = Document.parse(filterOperator.getOperatorExpression().toString());

        // Deleting documents that match the filter
        newStagesList.add(new DeleteStage(filter, null));

        return new MongoDbDeletes(this, newStagesList);
    }

    public static MongoDbDeletes newMongoDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        return new MongoDbDeletes(noSqlDbConnector, dataCollection);
    }

    private static class DeleteStage {
        private final Document filter;
        private final Document update; // This is used for "unsetting" fields, not for actual deletes

        public DeleteStage(Document filter, Document update) {
            this.filter = filter;
            this.update = update;
        }

        public Document getFilter() {
            return filter;
        }

        public Document getUpdate() {
            return update;
        }
    }
}
