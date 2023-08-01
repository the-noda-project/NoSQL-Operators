package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }


    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder("COUNTNULL(");
        operation.append(getFieldName());
        operation.append(")");
        return operation;
    }
}
