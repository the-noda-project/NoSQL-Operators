package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class CouchDBDeletes extends NoSqlDbDeletes {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final List<Delete> deletes;

    private CouchDBDeletes(CouchDBConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        deletes = Collections.emptyList();
    }

    private CouchDBDeletes(CouchDBDeletes self, List<Delete> deletes) {
        super(self.getNoSqlDbConnector(), self.getDataCollection());
        this.deletes = deletes;
    }

    public static CouchDBDeletes newCouchDbDeletes(CouchDBConnector connector, String s) {
        return new CouchDBDeletes(connector, s);
    }

    @Override
    public NoSqlDbDeletes flush() {
        if (deletes.isEmpty()) {
            return this;
        }

        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        for (Delete delete : deletes) {
            try {
                List<JsonObject> docs = connection.queryFind(getDataCollection(), delete.query).docs;

                for (JsonObject doc : docs) {
                    if (delete.fields.isEmpty()) { // Delete the entire document if no fields were specified...
                        // Marks the document as deleted in CouchDB
                        doc.addProperty("_deleted", true);
                    } else { // ...or delete specific fields from the document
                        for (String field : delete.fields) {
                            doc.remove(field);
                        }
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
    public NoSqlDbDeletes delete(String... fields) {
        List<Delete> deletes = new ArrayList<>(this.deletes);

        deletes.add(new Delete(new Query(), Arrays.asList(fields)));

        return new CouchDBDeletes(this, deletes);
    }

    @Override
    public NoSqlDbDeletes delete(FilterOperator fop, String... fields) {
        List<Delete> deletes = new ArrayList<>(this.deletes);

        Query query = new Query();
        query.addFilter((FilterStrategy) fop.getOperatorExpression());

        deletes.add(new Delete(query, Arrays.asList(fields)));

        return new CouchDBDeletes(this, deletes);
    }

    private static class Delete {
        private final Query query;
        private final List<String> fields;

        private Delete(Query query, List<String> fields) {
            this.query = query;
            this.fields = fields;
        }
    }
}
