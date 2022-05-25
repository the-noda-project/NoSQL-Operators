package gr.ds.unipi.noda.api.couchdb.sortOperators;

import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;

public final class CouchDBSortOperatorFactory extends BaseSortOperatorFactory {

    @Override
    public SortOperator newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }

}
