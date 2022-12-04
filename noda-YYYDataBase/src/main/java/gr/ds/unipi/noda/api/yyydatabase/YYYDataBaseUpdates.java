package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class YYYDataBaseUpdates extends NoSqlDbUpdates {

    private final YYYDataBaseConnectionManager yyyDataBaseConnectionManager = YYYDataBaseConnectionManager.getInstance();

    protected YYYDataBaseUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbUpdates flush() {
        return null;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static YYYDataBaseUpdates newYYYDataBaseUpdate(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new YYYDataBaseUpdates(noSqlDbConnector, dataCollection);
    }
}
