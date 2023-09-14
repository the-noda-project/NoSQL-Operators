package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import org.apache.commons.lang3.tuple.ImmutablePair;

public final class CouchDBAggregateOperatorFactory extends BaseAggregateOperatorFactory {
    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorMax(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorMin(String fieldName) {
        return OperatorMin.newOperatorMin(fieldName);
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorAvg(String fieldName) {
        return OperatorAvg.newOperatorAvg(fieldName);
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorSum(String fieldName) {
        return OperatorSum.newOperatorSum(fieldName);
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorCount() {
        return OperatorCount.newOperatorCount();
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorCountNonNull(String fieldName) {
        return OperatorCountNonNull.newOperatorCountNonNull(fieldName);
    }

    @Override
    public AggregateOperator<ImmutablePair<String, String>> newOperatorCountDistinct(String fieldName) {
        return OperatorCountDistinct.newOperatorCountDistinct(fieldName);
    }
}
