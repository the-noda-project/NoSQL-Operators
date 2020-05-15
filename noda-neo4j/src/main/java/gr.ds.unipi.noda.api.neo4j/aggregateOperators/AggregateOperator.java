package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<String> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    protected abstract String getAggregateOperatorField();

    @Override
    public String getOperatorExpression() {
        String exp;
        if (getAggregateOperatorField() == "count(*)") {
            exp = getAggregateOperatorField();
        } else if (getAggregateOperatorField() == "count( distinct ") {
            exp = getAggregateOperatorField() + "s." + getFieldName() + ")";
        }
        else {
            exp = getAggregateOperatorField() + "(s." + getFieldName() + ")";
        }

        return exp;

        }
    }
