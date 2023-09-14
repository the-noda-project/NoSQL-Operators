package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CouchDBUpdates extends NoSqlDbUpdates {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final List<Update> updates;

    private CouchDBUpdates(CouchDBConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        updates = Collections.emptyList();
    }

    private CouchDBUpdates(CouchDBUpdates self, List<Update> updates) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.updates = updates;
    }

    public static CouchDBUpdates newCouchDbUpdates(CouchDBConnector connector, String s) {
        return new CouchDBUpdates(connector, s);
    }

    @Override
    public NoSqlDbUpdates flush() {
        if (updates.isEmpty()) {
            return this;
        }

        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        for (Update update : updates) {
            try {
                List<JsonObject> docs = connection.queryFind(getDataCollection(), update.query).docs;

                for (JsonObject doc : docs) {
                    for (FieldValue<?> fv : update.fieldValues) {
                        doc.add(fv.getField(), new Gson().toJsonTree(fv.getValue()));
                    }
                }

                connection.bulkDocs(getDataCollection(), docs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        List<FieldValue> fieldValues = new ArrayList<>();
        fieldValues.add(fv);
        Collections.addAll(fieldValues, fvs);

        Query query = new Query();
        query.addFilter((FilterStrategy) filterOperator.getOperatorExpression());

        List<Update> updates = new ArrayList<>(this.updates);
        updates.add(new Update(query, fieldValues));

        return new CouchDBUpdates(this, updates);
    }

    private static class Update {
        private final Query query;
        private final List<FieldValue> fieldValues;

        private Update(Query query, List<FieldValue> fieldValues) {
            this.query = query;
            this.fieldValues = fieldValues;
        }
    }
}
