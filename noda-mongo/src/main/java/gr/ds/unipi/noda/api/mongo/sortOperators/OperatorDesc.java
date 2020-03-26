package gr.ds.unipi.noda.api.mongo.sortOperators;

class OperatorDesc extends SortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName, -1);
    }

    public static SortOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

}
