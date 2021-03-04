package gr.ds.unipi.noda.api.yyydatabase.aggregateOperators;

public class OperatorCountDistinct extends AggregateOperator {

    private OperatorCountDistinct(String fieldName) {
        super(fieldName, "countDistinct_" + fieldName);
    }

    public static OperatorCountDistinct newOperatorCountDistinct(String fieldName) {
        return new OperatorCountDistinct(fieldName);
    }

}
