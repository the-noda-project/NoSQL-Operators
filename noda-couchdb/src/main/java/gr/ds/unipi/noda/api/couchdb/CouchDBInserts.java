package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class CouchDBInserts extends NoSqlDbInserts {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final List<JsonObject> documents;

    private CouchDBInserts(CouchDBConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        documents = Collections.emptyList();
    }

    private CouchDBInserts(CouchDBInserts self, List<JsonObject> documents) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.documents = documents;
    }

    public static CouchDBInserts newCouchDbInserts(CouchDBConnector noSqlDbConnector, String dataCollection) {
        return new CouchDBInserts(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        if (documents.isEmpty()) {
            return this;
        }

        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());
        try {
            connection.bulkDocs(getDataCollection(), documents);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        List<JsonObject> documents = new ArrayList<>(this.documents);
        Map<String, Object> document = Stream.concat(Stream.of(fv), Stream.of(fvs))
                .collect(Collectors.toMap(FieldValue::getField, FieldValue::getValue));

        documents.add(new Gson().toJsonTree(document).getAsJsonObject());

        return new CouchDBInserts(this, documents);
    }
}
