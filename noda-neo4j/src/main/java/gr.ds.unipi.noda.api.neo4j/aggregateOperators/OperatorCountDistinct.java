package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

public class OperatorCountDistinct extends AggregateOperator {

    private OperatorCountDistinct(String fieldName) {
        super(fieldName, "countDistinct_" + fieldName);
    }

    public static OperatorCountDistinct newOperatorCountDistinct(String fieldName) {
        return new OperatorCountDistinct(fieldName);
    }

    @Override
    protected String getAggregateOperatorField() {

        return "count( distinct ";
    }

}