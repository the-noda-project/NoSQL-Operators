package gr.ds.unipi.noda.api.cassandra.sortOperators;
import java.lang.StringBuilder;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<Object> {
    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}
