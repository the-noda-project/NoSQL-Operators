package gr.ds.unipi.noda.api.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MongoDbUpdates extends NoSqlDbUpdates {
    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final String database;
    private final List<UpdateStage> stagesList;

    protected MongoDbUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        this.stagesList = Collections.emptyList();
        MongoDBConnector mongoDBConnector = ((MongoDBConnector) noSqlDbConnector);
        database = mongoDBConnector.getDatabase();
    }

    private MongoDbUpdates(MongoDbUpdates self, List<UpdateStage> stagesList) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.stagesList = stagesList;
        this.database = self.getDatabase();
    }

    private String getDatabase() {
        return database;
    }

    @Override
    public NoSqlDbUpdates flush() {
        if (stagesList.isEmpty())
            return this;

        MongoClient connectionManager = mongoDBConnectionManager.getConnection(getNoSqlDbConnector());
        MongoDatabase db = connectionManager.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(getDataCollection());

        for (UpdateStage stage : stagesList) {
            collection.updateMany(stage.getFilter(), stage.getUpdate());
        }

        return new MongoDbUpdates(this, Collections.emptyList());
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        List<UpdateStage> newStagesList = new ArrayList<>(this.stagesList);

        Map<String, Object> updateMap = Stream.concat(Stream.of(fv), Stream.of(fvs))
                .collect(Collectors.toMap(FieldValue::getField, FieldValue::getValue));

        String compiledFilterOperator = filterOperator.getOperatorExpression().toString();

        Document filter = Document.parse(compiledFilterOperator);
        Document update = new Document("$set", new Document(updateMap));

        newStagesList.add(new UpdateStage(filter, update));

        return new MongoDbUpdates(this, newStagesList);
    }

    public static MongoDbUpdates newMongoUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        return new MongoDbUpdates(noSqlDbConnector, dataCollection);
    }

    private static class UpdateStage {
        private final Document filter;
        private final Document update;

        public UpdateStage(Document filter, Document update) {
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