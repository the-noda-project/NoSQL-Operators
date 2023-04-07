package gr.ds.unipi.noda.api.couchdb;

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
    private final List<Map<String, Object>> documents;

    private CouchDBInserts(CouchDBConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        documents = Collections.emptyList();
    }

    private CouchDBInserts(CouchDBInserts self, List<Map<String, Object>> documents) {
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

        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());
        connection.bulkDocs(getDataCollection(), documents);

        return this;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        List<Map<String, Object>> documents = new ArrayList<>(this.documents);
        Map<String, Object> document = Stream.concat(Stream.of(fv), Stream.of(fvs))
                .collect(Collectors.toMap(FieldValue::getField, FieldValue::getValue));

        documents.add(document);

        return new CouchDBInserts(this, documents);
    }
}
