package gr.unipi.noda.api.core.operators;

import gr.unipi.noda.api.core.operators.sortOperators.SortOperator;

public class SortOperators {

    public static SortOperator asc(String fieldName) {
        return SortOperator.sortOperator.newOperatorAsc(fieldName);
    }

    public static SortOperator desc(String fieldName) {
        return SortOperator.sortOperator.newOperatorDesc(fieldName);
    }

}
