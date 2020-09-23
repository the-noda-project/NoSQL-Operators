package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public class Range implements FilterOperator<String> {

    private final ComparisonOperator comparisonOperator1;
    private final ComparisonOperator comparisonOperator2;

    private Range(ComparisonOperator comparisonOperator1, ComparisonOperator comparisonOperator2){
        this.comparisonOperator1 = comparisonOperator1;
        this.comparisonOperator2 = comparisonOperator2;

    }

    @Override
    public String getOperatorExpression() {
        return null;
    }

    public static Range newRange(ComparisonOperator comparisonOperator1, ComparisonOperator comparisonOperator2){
        return new Range(comparisonOperator1, comparisonOperator2);
    }
}
