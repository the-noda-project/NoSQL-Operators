package gr.ds.unipi.noda.api.YYYDataBase.aggregateOperator;

class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, "avg_" + fieldName);
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

}
