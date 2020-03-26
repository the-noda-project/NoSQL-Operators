package gr.ds.unipi.noda.api.YYYDataBase.aggregateOperator;

class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

}
