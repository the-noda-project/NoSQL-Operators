package gr.ds.unipi.noda.api.couchdb.sortOperators;

import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.commons.lang3.tuple.ImmutablePair;

public final class CouchDBSortOperatorFactory extends BaseSortOperatorFactory {
    @Override
    public SortOperator<ImmutablePair<String, String>> newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator<ImmutablePair<String, String>> newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }

}
