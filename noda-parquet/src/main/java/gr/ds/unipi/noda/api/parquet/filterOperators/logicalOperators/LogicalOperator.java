package gr.ds.unipi.noda.api.parquet.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.apache.parquet.filter2.predicate.FilterPredicate;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<FilterPredicate> {
    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    protected abstract FilterPredicate getOperator(FilterPredicate fp1, FilterPredicate fp2);

    @Override
    public FilterPredicate getOperatorExpression() {
        FilterPredicate fp = getOperator((FilterPredicate) getFilterOperatorChildren()[0].getOperatorExpression(), (FilterPredicate) getFilterOperatorChildren()[1].getOperatorExpression());
        for (int i = 2; i < this.getFilterOperatorChildren().length; i++) {
            fp = getOperator(fp, (FilterPredicate) getFilterOperatorChildren()[i].getOperatorExpression());
        }
        return fp;
    }
}
