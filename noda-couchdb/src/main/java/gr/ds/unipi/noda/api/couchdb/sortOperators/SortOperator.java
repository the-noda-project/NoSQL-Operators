package gr.ds.unipi.noda.api.couchdb.sortOperators;

import java.util.Collections;
import java.util.Map;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<Map<String, String>> {
    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    protected abstract String orderName();

    @Override
    public Map<String, String> getOperatorExpression() {
        return Collections.singletonMap(getFieldName(), orderName());
    }
}
