package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        for (Delete delete : deletes) {
            try {
                ViewResponse res = delete.viewQuery == null ? connection.allDocs(getDataCollection())
                                                            : connection.runQuery(getDataCollection(), delete.viewQuery);

                if (res == null) {
                    continue;
                }

                List<JsonObject> docs = res.rows.stream().map(row -> {
                    // Delete the document if no fields were specified
                    if (delete.fields.isEmpty()) {
                        // Marks the document as deleted in CouchDB
                        row.doc.addProperty("_deleted", true);
                    } else {
                        for (String field : delete.fields) {
                            row.doc.remove(field);
                        }
                    }

                    return row.doc;
                }).collect(Collectors.toList());

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

        deletes.add(new Delete(null, Arrays.asList(fields)));

        return new CouchDBDeletes(this, deletes);
    }

    @Override
    public NoSqlDbDeletes delete(FilterOperator fop, String... fields) {
        List<Delete> deletes = new ArrayList<>(this.deletes);

        ViewQuery viewQuery = new ViewQuery();
        viewQuery.addFilter(fop);

        deletes.add(new Delete(viewQuery, Arrays.asList(fields)));

        return new CouchDBDeletes(this, deletes);
    }

    private static class Delete {
        private final ViewQuery viewQuery;
        private final List<String> fields;

        private Delete(ViewQuery viewQuery, List<String> fields) {
            this.viewQuery = viewQuery;
            this.fields = fields;
        }
    }
}
