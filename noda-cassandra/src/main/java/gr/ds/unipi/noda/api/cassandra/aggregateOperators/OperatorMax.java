package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

final class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, "max_" + fieldName);
    }

    public static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append("MAX(");
        operation.append(getFieldName());
        operation.append(")");
        return operation;
    }
}
