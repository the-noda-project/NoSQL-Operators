package gr.ds.unipi.noda.api.cassandra.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class OperatorAnd extends LogicalOperator {
    @Override
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder();
        operation.append(getFilterOperatorChildren()[0].getOperatorExpression());
        System.out.println(getFilterOperatorChildren()[0].getOperatorExpression()); //REMOVE
        for(int i=1 ; i<getFilterOperatorChildren().length; i++){
            System.out.println(getFilterOperatorChildren()[i].getOperatorExpression()); //REMOVE
            operation.append(" AND ");
            operation.append(getFilterOperatorChildren()[i].getOperatorExpression());
        }
        return operation;
    }
    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

}
