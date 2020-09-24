package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return Objects.equals(comparisonOperator1, range.comparisonOperator1) &&
                Objects.equals(comparisonOperator2, range.comparisonOperator2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comparisonOperator1, comparisonOperator2);
    }

    public StringBuilder toString(String level){
        StringBuilder sb = new StringBuilder();
        sb.append("-"+level+getClass()+"\n 1: "+ comparisonOperator1.toString(level) +" 2: "+ comparisonOperator2.toString(level));
        return sb;
    }
}
