package gr.ds.unipi.noda.api.cassandra.sortOperators;

final class OperatorDesc extends SortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName);
    }

    public static SortOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append(" DESC");
        return operation;
    }

}
