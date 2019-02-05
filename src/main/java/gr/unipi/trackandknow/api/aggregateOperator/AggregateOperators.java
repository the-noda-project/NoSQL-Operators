package gr.unipi.trackandknow.api.aggregateOperator;

public class AggregateOperators {

    public static AggregateOperator max(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

    public static AggregateOperator min(String fieldName) {
        return OperatorMin.newOperatorMin(fieldName);
    }

    public static AggregateOperator avg(String fieldName) {
        return OperatorAvg.newOperatorAvg(fieldName);
    }

    public static AggregateOperator sum(String fieldName) {
        return OperatorSum.newOperatorSum(fieldName);
    }

    public static AggregateOperator count() {
        return OperatorCount.newOperatorCount();
    }
}
