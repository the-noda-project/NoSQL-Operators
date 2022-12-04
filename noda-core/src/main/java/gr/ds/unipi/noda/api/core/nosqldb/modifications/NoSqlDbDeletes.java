package gr.ds.unipi.noda.api.core.nosqldb.modifications;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class NoSqlDbDeletes extends NoSqlDbModifications{

    protected NoSqlDbDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public abstract NoSqlDbDeletes flush();

    public abstract NoSqlDbDeletes delete(String... fields);

    public abstract NoSqlDbDeletes delete(FilterOperator fop, String... fields);

}
