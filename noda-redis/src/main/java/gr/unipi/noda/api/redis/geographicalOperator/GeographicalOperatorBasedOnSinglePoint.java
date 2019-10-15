package gr.unipi.noda.api.redis.geographicalOperator;

import gr.unipi.noda.api.redis.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

/**
 * @author adimo on 11/10/2019
 */
abstract class GeographicalOperatorBasedOnSinglePoint extends gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnSinglePoint<StringBuilder> {
    GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
        super(fieldName, point);
    }

    public enum Unit {
        m, km, mi, ft
    }
    protected abstract String getOperatorField();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringPool.AT).append(getFieldName()).append(StringPool.COLON).append(getOperatorField());
        return sb;
    }
}
