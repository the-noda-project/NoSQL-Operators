package gr.ds.unipi.noda.api.cassandra.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.ArrayList;

final class OperatorAnd extends LogicalOperator {
    @Override
    public ArrayList<FilterOperator> getOperatorExpression() {
        ArrayList<FilterOperator> operations = new ArrayList<>();
        for (FilterOperator fop : getFilterOperatorChildren()) {
            if (fop.getClass().getSimpleName().equals("OperatorAnd")) {
                operations.addAll((ArrayList<FilterOperator>) fop.getOperatorExpression());
            } else {
                operations.add(fop);
            }
        }
        return operations;
    }

    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

}
