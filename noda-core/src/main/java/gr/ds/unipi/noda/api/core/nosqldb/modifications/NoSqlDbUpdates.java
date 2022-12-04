package gr.ds.unipi.noda.api.core.nosqldb.modifications;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class NoSqlDbUpdates extends NoSqlDbModifications{

    protected NoSqlDbUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public abstract NoSqlDbUpdates flush();

    public abstract NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs);


}
