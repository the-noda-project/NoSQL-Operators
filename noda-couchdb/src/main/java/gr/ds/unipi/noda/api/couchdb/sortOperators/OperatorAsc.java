package gr.ds.unipi.noda.api.couchdb.sortOperators;

final class OperatorAsc extends SortOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName);
    }

    @Override
    protected String orderName() {
        return "ascending";
    }

    public static SortOperator newOperatorAsc(String fieldName) {
        return new OperatorAsc(fieldName);
    }

}
