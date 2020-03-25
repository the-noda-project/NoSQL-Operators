package gr.ds.unipi.noda.api.YYYDataBase.aggregateOperator;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<Object> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

}
