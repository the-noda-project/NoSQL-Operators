package gr.unipi.noda.api.mongo.sortOperator;

public class SortOperators {

    public static SortOperator asc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    public static SortOperator desc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }
}
