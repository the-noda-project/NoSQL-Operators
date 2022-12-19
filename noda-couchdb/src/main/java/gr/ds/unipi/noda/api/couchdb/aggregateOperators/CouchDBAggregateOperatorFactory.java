package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;

public final class CouchDBAggregateOperatorFactory extends BaseAggregateOperatorFactory {
    @Override
    public AggregateOperator<String[]> newOperatorMax(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

    @Override
    public AggregateOperator<String[]> newOperatorMin(String fieldName) {
        return OperatorMin.newOperatorMin(fieldName);
    }

    @Override
    public AggregateOperator<String[]> newOperatorAvg(String fieldName) {
        return OperatorAvg.newOperatorAvg(fieldName);
    }

    @Override
    public AggregateOperator<String[]> newOperatorSum(String fieldName) {
        return OperatorSum.newOperatorSum(fieldName);
    }

    @Override
    public AggregateOperator<String[]> newOperatorCount() {
        return OperatorCount.newOperatorCount();
    }

    @Override
    public AggregateOperator<String[]> newOperatorCountNonNull(String fieldName) {
        return OperatorCountNonNull.newOperatorCountNonNull(fieldName);
    }

    @Override
    public AggregateOperator<String[]> newOperatorCountDistinct(String fieldName) {
        return OperatorCountDistinct.newOperatorCountDistinct(fieldName);
    }
}
