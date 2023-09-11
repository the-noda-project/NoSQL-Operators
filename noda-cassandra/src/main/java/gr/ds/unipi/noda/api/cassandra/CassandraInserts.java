package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

import java.util.*;

public final class CassandraInserts extends NoSqlDbInserts {
    private static ArrayList<String> insertQueries = new ArrayList<String>();
    private static Map<String, String> monthToInt;

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();


    protected CassandraInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
        monthToInt = new HashMap<String, String>();
        monthToInt.put("Jan", "01");
        monthToInt.put("Feb", "02");
        monthToInt.put("Mar", "03");
        monthToInt.put("Apr", "04");
        monthToInt.put("May", "05");
        monthToInt.put("Jun", "06");
        monthToInt.put("Jul", "07");
        monthToInt.put("Aug", "08");
        monthToInt.put("Sem", "09");
        monthToInt.put("Oct", "10");
        monthToInt.put("Nov", "11");
        monthToInt.put("Dec", "12");
    }

    @Override
    public NoSqlDbInserts flush() {
        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("BEGIN BATCH ");
        for (String query : insertQueries) {
            insertQuery.append(query);
        }
        insertQuery.append("APPLY BATCH");
        cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute((insertQuery.toString()));
        insertQueries = new ArrayList<String>();
        return this;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        FieldValue[] fieldValues = new FieldValue[fvs.length + 1];
        fieldValues[0] = fv;
        System.arraycopy(fvs, 0, fieldValues, 1, fvs.length);
        StringJoiner fields = new StringJoiner(",");
        StringJoiner values = new StringJoiner(",");
        for (int i = 0; i < fieldValues.length; i++) {
            fields.add(fieldValues[i].getField());
            if (fieldValues[i].getValue() instanceof String) {
                values.add(formatStrings(new String[]{(String) fieldValues[i].getValue()})[0]);
            } else if (fieldValues[i].getValue() instanceof Date) {
                values.add(formatDates(new Date[]{(Date) fieldValues[i].getValue()})[0]);
            } else if (fieldValues[i].getValue() instanceof String[]) {
                values.add(Arrays.toString(formatStrings((String[]) fieldValues[i].getValue())));
            } else if (fieldValues[i].getValue() instanceof Date[]) {
                values.add(Arrays.toString(formatDates((Date[]) fieldValues[i].getValue())));
            } else if (fieldValues[i].getValue() instanceof Object[]) {
                values.add(Arrays.toString((Object[]) fieldValues[i].getValue()));
            } else {
                values.add("" + fieldValues[i].getValue());
            }
        }
        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("INSERT INTO ");
        insertQuery.append(getDataCollection());
        insertQuery.append(" (");
        insertQuery.append(fields.toString());
        insertQuery.append(") VALUES (");
        insertQuery.append(values.toString());
        insertQuery.append(");");
        insertQueries.add(insertQuery.toString());
        return this;
    }

    public static CassandraInserts newCassandraInsert(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        return new CassandraInserts(noSqlDbConnector, dataCollection);
    }

    private String[] formatStrings(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = '\'' + strings[i] + '\'';
        }
        return strings;
    }

    private String[] formatDates(Date[] dates) {
        String[] formattedDates = new String[dates.length];
        for (int i = 0; i < dates.length; i++) {
            String[] dateComponents = dates[i].toString().split(" ");
            String yyyy = dateComponents[5];
            String mm = monthToInt.get(dateComponents[1]);
            String dd = dateComponents[2];
            formattedDates[i] = '\'' + yyyy + '-' + mm + '-' + dd + '\'';
        }
        return formattedDates;
    }
}
