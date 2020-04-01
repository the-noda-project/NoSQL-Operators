package gr.ds.unipi.noda.api.neo4j.sortOperators;

final class OperatorDesc extends SortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName);
    }

    public static SortOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

    @Override
    protected String getSortCondition() {
        return " DESC ";
    }

}
