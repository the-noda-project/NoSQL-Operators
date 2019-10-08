package gr.unipi.noda.api.core.operators.aggregateOperators;

import gr.unipi.noda.api.core.operators.Operators;
import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;

public class AggregateOperators {
    public static AggregateOperator max(String fieldName) {
        return Operators.aggregateOperator.newOperatorMax(fieldName);
    }

    public static AggregateOperator min(String fieldName) {
        return Operators.aggregateOperator.newOperatorMin(fieldName);
    }

    public static AggregateOperator avg(String fieldName) {
        return Operators.aggregateOperator.newOperatorAvg(fieldName);
    }

    public static AggregateOperator sum(String fieldName) {
        return Operators.aggregateOperator.newOperatorSum(fieldName);
    }

    public static AggregateOperator sum() {
        return Operators.aggregateOperator.newOperatorCount();
    }
}
