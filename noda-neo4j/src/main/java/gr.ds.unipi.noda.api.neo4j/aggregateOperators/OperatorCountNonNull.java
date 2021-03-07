package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }

    @Override
    protected String getAggregateOperatorField() {

        return "count";
    }

}
