package gr.ds.unipi.noda.api.core.operators.aggregateOperators;

public abstract class BaseAggregateOperatorFactory {
    public abstract AggregateOperator newOperatorMax(String fieldName);

    public abstract AggregateOperator newOperatorMin(String fieldName);

    public abstract AggregateOperator newOperatorAvg(String fieldName);

    public abstract AggregateOperator newOperatorSum(String fieldName);

    public abstract AggregateOperator newOperatorCount();

    public abstract AggregateOperator newOperatorCountNonNull(String fieldName);

    public abstract AggregateOperator newOperatorCountDistinct(String fieldName);


}
