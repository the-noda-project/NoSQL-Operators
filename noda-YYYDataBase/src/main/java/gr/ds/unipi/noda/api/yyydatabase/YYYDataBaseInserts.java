package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

public final class YYYDataBaseInserts extends NoSqlDbInserts {

    private final YYYDataBaseConnectionManager yyyDataBaseConnectionManager = YYYDataBaseConnectionManager.getInstance();

    protected YYYDataBaseInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        return null;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static YYYDataBaseInserts newYYYDataBaseInsert(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new YYYDataBaseInserts(noSqlDbConnector, dataCollection);
    }
}
