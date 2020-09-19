package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<List<Map.Entry<Operator, String[]>> , U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public List<Map.Entry<Operator, String[]>> getOperatorExpression() {
        List<Map.Entry<Operator, String[]>> list = new ArrayList();
        list.add(new AbstractMap.SimpleImmutableEntry<>(this, new String[]{RandomStringGenerator.randomCharacterNumericString()}));
        return list;
    }
}
