package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

final class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder(" COUNT(*) ");
        return operation;
    }

}
