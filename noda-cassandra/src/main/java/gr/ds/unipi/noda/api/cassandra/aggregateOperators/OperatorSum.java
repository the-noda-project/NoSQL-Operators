package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

final class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, "sum_" + fieldName);
    }

    public static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append("SUM(");
        operation.append(getFieldName());
        operation.append(")");
        return operation;
    }

}
