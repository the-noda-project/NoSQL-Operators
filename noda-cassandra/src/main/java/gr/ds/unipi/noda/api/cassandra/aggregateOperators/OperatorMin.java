package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

final class OperatorMin extends AggregateOperator {

    private OperatorMin(String fieldName) {
        super(fieldName, "min_" + fieldName);
    }

    public static OperatorMin newOperatorMin(String fieldName) {
        return new OperatorMin(fieldName);
    }

    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append("MIN(");
        operation.append(getFieldName());
        operation.append(")");
        return operation;
    }

}
