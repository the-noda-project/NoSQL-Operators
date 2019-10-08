package gr.unipi.noda.api.mongo.aggregateOperator;

import gr.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;

public class MongoAggregateOperatorFactory<T> extends BaseAggregateOperatorFactory<T> {

    /*public static AggregateOperator max(String fieldName) {
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
    }*/

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
}
