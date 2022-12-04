package gr.ds.unipi.noda.api.core.nosqldb.modifications;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public abstract class NoSqlDbInserts extends NoSqlDbModifications{

    protected NoSqlDbInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public abstract NoSqlDbInserts flush();

    public abstract NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs);

}
