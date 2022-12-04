package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class YYYDataBaseDeletes extends NoSqlDbDeletes {

    private final YYYDataBaseConnectionManager yyyDataBaseConnectionManager = YYYDataBaseConnectionManager.getInstance();

    protected YYYDataBaseDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbDeletes flush() {
        return null;
    }

    @Override
    public NoSqlDbDeletes delete(String... fields) {
        return null;
    }

    @Override
    public NoSqlDbDeletes delete(FilterOperator fop, String... fields) {
        return null;
    }

    public static YYYDataBaseDeletes newYYYDataBaseDelete(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new YYYDataBaseDeletes(noSqlDbConnector, dataCollection);
    }
}
