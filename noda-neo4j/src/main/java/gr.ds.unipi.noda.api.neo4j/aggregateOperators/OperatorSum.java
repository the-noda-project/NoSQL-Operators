package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

final class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, "sum_" + fieldName);
    }

    public static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected String getAggregateOperatorField() {

        return "sum";
    }

}
