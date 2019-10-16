package gr.ds.unipi.noda.api.core.operators.sortOperators;

public abstract class BaseSortOperatorFactory {

    public abstract SortOperator newOperatorAsc(String fieldName);

    public abstract SortOperator newOperatorDesc(String fieldName);
}
