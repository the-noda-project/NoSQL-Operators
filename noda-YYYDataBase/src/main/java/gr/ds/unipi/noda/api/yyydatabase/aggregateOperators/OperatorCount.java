package gr.ds.unipi.noda.api.yyydatabase.aggregateOperators;

final class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

}
