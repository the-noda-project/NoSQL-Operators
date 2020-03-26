package gr.ds.unipi.noda.api.mongo.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<StringBuilder> {

    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    protected abstract String getOperatorJsonField();

    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();

        sb.append("{ $");
        sb.append(getOperatorJsonField());
        sb.append(": [ ");

        for (FilterOperator fop : getFilterOperatorChildren()) {

            sb.append(fop.getOperatorExpression());
            sb.append(", ");

        }
        sb.deleteCharAt(sb.lastIndexOf(", "));

        sb.append(" ] }");

        return sb;
    }


}
