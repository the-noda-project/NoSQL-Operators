package gr.ds.unipi.noda.api.core.operators;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;

public class AggregateOperators {
    public static AggregateOperator max(String fieldName) {
        return AggregateOperator.aggregateOperator.newOperatorMax(fieldName);
    }

    public static AggregateOperator min(String fieldName) {
        return AggregateOperator.aggregateOperator.newOperatorMin(fieldName);
    }

    public static AggregateOperator avg(String fieldName) {
        return AggregateOperator.aggregateOperator.newOperatorAvg(fieldName);
    }

    public static AggregateOperator sum(String fieldName) {
        return AggregateOperator.aggregateOperator.newOperatorSum(fieldName);
    }

    public static AggregateOperator sum() {
        return AggregateOperator.aggregateOperator.newOperatorCount();
    }
}
