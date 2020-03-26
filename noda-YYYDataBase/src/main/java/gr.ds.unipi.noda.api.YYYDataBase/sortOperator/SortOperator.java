package gr.ds.unipi.noda.api.YYYDataBase.sortOperator;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<Object> {
    protected SortOperator(String fieldName, int order) {
        super(fieldName, order);
    }
}
