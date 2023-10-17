package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.*;


final class CassandraUpdates extends NoSqlDbUpdates {

    private static ArrayList<String> updateFops = new ArrayList<String>();
    private static ArrayList<String> updateFvs = new ArrayList<String>();
    private static Map<String, String> monthToInt;


    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();

    protected CassandraUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
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
    public NoSqlDbUpdates flush() {
        for (int i = 0; i < updateFops.size(); i++) {
            StringBuilder query = new StringBuilder();
            query.append("UPDATE ");
            query.append(getDataCollection());
            query.append(" SET ");
            query.append(updateFvs.get(i));
            query.append(" WHERE ");
            query.append(updateFops.get(i));
            query.append(";");
            cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query.toString());
        }
        updateFops = new ArrayList<String>();
        updateFvs = new ArrayList<String>();
        return this;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        updateFops.add(filterOperator.getOperatorExpression().toString());
        FieldValue[] fvsArray = new FieldValue[fvs.length + 1];
        fvsArray[0] = fv;
        System.arraycopy(fvs, 0, fvsArray, 1, fvs.length);
        StringJoiner assignments = new StringJoiner(",");
        for (FieldValue currentFieldValue : fvsArray) {
            if (currentFieldValue.getValue() instanceof String) {
                assignments.add(currentFieldValue.getField() + '=' + formatStrings(new String[]{(String) currentFieldValue.getValue()})[0]);
            } else if (currentFieldValue.getValue() instanceof Date) {
                assignments.add(currentFieldValue.getField() + '=' + formatDates(new Date[]{(Date) currentFieldValue.getValue()})[0]);
            } else if (currentFieldValue.getValue() instanceof String[]) {
                assignments.add(currentFieldValue.getField() + '=' + Arrays.toString(formatStrings((String[]) currentFieldValue.getValue())));
            } else if (currentFieldValue.getValue() instanceof Date[]) {
                assignments.add(currentFieldValue.getField() + '=' + Arrays.toString(formatDates((Date[]) currentFieldValue.getValue())));
            } else if (currentFieldValue.getValue() instanceof Object[]) {
                assignments.add(currentFieldValue.getField() + '=' + Arrays.toString((Object[]) currentFieldValue.getValue()));
            } else {
                assignments.add(currentFieldValue.getField() + '=' + currentFieldValue.getValue());
            }
        }
        updateFvs.add(assignments.toString());
        return this;
    }

    public static CassandraUpdates newCassandraUpdate(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        return new CassandraUpdates(noSqlDbConnector, dataCollection);
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
