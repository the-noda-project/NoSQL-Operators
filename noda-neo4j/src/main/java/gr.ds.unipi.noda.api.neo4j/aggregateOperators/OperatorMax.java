package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

final class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, "max_" + fieldName);
    }

    public static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    @Override
    protected String getAggregateOperatorField() {

        return "max";
    }

}
