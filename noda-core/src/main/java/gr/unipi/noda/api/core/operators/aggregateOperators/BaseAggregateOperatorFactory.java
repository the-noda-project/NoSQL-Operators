package gr.unipi.noda.api.core.operators.aggregateOperators;

import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;

public abstract class BaseAggregateOperatorFactory {
    public abstract AggregateOperator newOperatorMax(String fieldName);
    public abstract AggregateOperator newOperatorMin(String fieldName);
    public abstract AggregateOperator newOperatorAvg(String fieldName);
    public abstract AggregateOperator newOperatorSum(String fieldName);
    public abstract AggregateOperator newOperatorCount();
}
