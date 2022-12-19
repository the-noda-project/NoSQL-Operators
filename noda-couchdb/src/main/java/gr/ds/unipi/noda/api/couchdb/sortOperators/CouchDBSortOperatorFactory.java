package gr.ds.unipi.noda.api.couchdb.sortOperators;

import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;

import java.util.Map;

public final class CouchDBSortOperatorFactory extends BaseSortOperatorFactory {

    @Override
    public SortOperator<Map<String, String>> newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator<Map<String, String>> newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }

}
