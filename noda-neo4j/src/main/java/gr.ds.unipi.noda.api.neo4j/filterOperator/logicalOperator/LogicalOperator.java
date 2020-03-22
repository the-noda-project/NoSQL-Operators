package gr.ds.unipi.noda.api.neo4j.filterOperator.logicalOperator;

        import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<String> {

    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    public String getOperatorExpression() {
        StringBuilder sb = new StringBuilder();

        for (FilterOperator fop : getFilterOperatorChildren()) {

            sb.append(fop.getOperatorExpression());
            sb.append(getLogicalOperatorType());

        }

        String logicalType = getLogicalOperatorType();
        System.out.println(sb.lastIndexOf(logicalType));
        sb.delete( sb.length() - 4 , sb.length());
        return sb.toString();

    }

    abstract String getLogicalOperatorType();

}
