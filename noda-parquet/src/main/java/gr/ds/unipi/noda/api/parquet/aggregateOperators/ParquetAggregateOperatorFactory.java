package gr.ds.unipi.noda.api.parquet.aggregateOperators;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;

public final class ParquetAggregateOperatorFactory extends BaseAggregateOperatorFactory {
    @Override
    public AggregateOperator newOperatorMax(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

    @Override
    public AggregateOperator newOperatorMin(String fieldName) {
        return OperatorMin.newOperatorMin(fieldName);
    }

    @Override
    public AggregateOperator newOperatorAvg(String fieldName) {
        return OperatorAvg.newOperatorAvg(fieldName);
    }

    @Override
    public AggregateOperator newOperatorSum(String fieldName) {
        return OperatorSum.newOperatorSum(fieldName);
    }

    @Override
    public AggregateOperator newOperatorCount() {
        return OperatorCount.newOperatorCount();
    }

    @Override
    public AggregateOperator newOperatorCountNonNull(String fieldName) {
        return OperatorCountNonNull.newOperatorCountNonNull(fieldName);
    }

    @Override
    public AggregateOperator newOperatorCountDistinct(String fieldName) {
        return OperatorCountDistinct.newOperatorCountDistinct(fieldName);
    }
}
