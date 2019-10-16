package gr.ds.unipi.noda.api.mongo.sortOperator;

class OperatorAsc extends SortOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName, 1);
    }

    public static SortOperator newOperatorAsc(String fieldName) {
        return new OperatorAsc(fieldName);
    }
}
