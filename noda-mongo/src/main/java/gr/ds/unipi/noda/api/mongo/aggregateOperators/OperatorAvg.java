package gr.ds.unipi.noda.api.mongo.aggregateOperators;

class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, "avg_" + fieldName);
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected String getOperatorJsonField() {
        return "avg";
    }
}
