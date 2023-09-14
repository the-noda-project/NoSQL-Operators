package gr.ds.unipi.noda.api.couchdb.sortOperators;

final class OperatorDesc extends SortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName);
    }

    @Override
    protected String orderName() {
        return "descending";
    }

    public static SortOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

}
