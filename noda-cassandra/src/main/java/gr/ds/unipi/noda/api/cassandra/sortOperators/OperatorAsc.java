package gr.ds.unipi.noda.api.cassandra.sortOperators;

final class OperatorAsc extends SortOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName);
    }

    public static SortOperator newOperatorAsc(String fieldName) {
        return new OperatorAsc(fieldName);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append(" ASC");
        return operation;
    }

}
