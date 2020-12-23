package gr.ds.unipi.noda.api.redis.sortOperators;

final class OperatorDesc extends SortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName);
    }

    public static SortOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

}
