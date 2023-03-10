package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }


    public StringBuilder getOperatorExpression() {
        throw new UnsupportedOperationException("The count not null operation is not supported by Cassandra!");
    }
}
