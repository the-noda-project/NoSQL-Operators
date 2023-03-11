package gr.ds.unipi.noda.api.cassandra;

import java.util.*;
import java.util.ArrayList;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import java.lang.StringBuilder;

final class CassandraDeletes extends NoSqlDbDeletes {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();
    private static Set<String> dropFields = new HashSet<String>();
    private static int dropFieldsSize = 0;
    private static ArrayList<String> deleteFops = new ArrayList<String>();
    private static ArrayList<String[]> deleteFields = new ArrayList<String[]>();
    private static int deleteValuesSize = 0;

    protected CassandraDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbDeletes flush() {
        StringBuilder query = new StringBuilder();
        if(deleteValuesSize <= 50 && dropFieldsSize > 0){
            query.append("ALTER TABLE ");
            query.append(getDataCollection());
            query.append(" DROP (");
            query.append(dropFields.toString().replace("[","").replace("]", "").replace(" ",""));
            query.append(");");
            cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query.toString());
            dropFields = new HashSet<String>();
            dropFieldsSize = 0;
        }
        if(dropFieldsSize <= 50 && deleteValuesSize > 0){
            for(int i =0; i < deleteFops.size(); i++){
                query = new StringBuilder();
                query.append("DELETE ");
                query.append(Arrays.toString(deleteFields.get(i)).replace("[","").replace("]", "").replace(" ",""));
                query.append(" FROM ");
                query.append(getDataCollection());
                query.append(" WHERE ");
                query.append(deleteFops.get(i));
                query.append(";");
                cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query.toString());
            }
            deleteFops = new ArrayList<String>();
            deleteFields = new ArrayList<String[]>();
            deleteValuesSize = 0;
        }
        return this;
    }

    @Override
    public NoSqlDbDeletes delete(String... fields) {
        Collections.addAll(dropFields,  fields);
        dropFieldsSize += dropFields.toString().replace("[","").replace("]","").replace(" ","").getBytes().length;
        if(dropFieldsSize > 50)
            flush();
        return this;
    }

    @Override
    public NoSqlDbDeletes delete(FilterOperator fop, String... fields) {
        deleteFops.add(fop.getOperatorExpression().toString());
        deleteFields.add(fields);
        deleteValuesSize += deleteFops.toString().replace("]","").replace(" ","").getBytes().length + deleteFields.toString().replace("]","").replace(" ","").getBytes().length ;
        if( deleteValuesSize > 50)
            flush();
        return this;
    }

    public static CassandraDeletes newCassandraDelete(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new CassandraDeletes(noSqlDbConnector, dataCollection);
    }
}
