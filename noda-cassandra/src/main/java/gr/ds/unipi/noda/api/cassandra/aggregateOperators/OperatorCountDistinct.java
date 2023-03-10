package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

public class OperatorCountDistinct extends AggregateOperator {

    private OperatorCountDistinct(String fieldName) {
        super(fieldName, "countDistinct_" + fieldName);
    }

    public static OperatorCountDistinct newOperatorCountDistinct(String fieldName) {
        return new OperatorCountDistinct(fieldName);
    }

    public StringBuilder getOperatorExpression() {
        throw new UnsupportedOperationException("The count distinct operation is not supported by Cassandra!");
    }

}
