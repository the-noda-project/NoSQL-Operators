package gr.ds.unipi.noda.api.parquet.aggregateOperators;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<Object> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    @Override
    public Object getOperatorExpression(){
        return null;
    }
}
