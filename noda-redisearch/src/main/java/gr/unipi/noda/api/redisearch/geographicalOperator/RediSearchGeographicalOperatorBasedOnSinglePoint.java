package gr.unipi.noda.api.redisearch.geographicalOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnSinglePoint;

/**
 * @author adimo on 11/10/2019
 */
abstract class RediSearchGeographicalOperatorBasedOnSinglePoint extends GeographicalOperatorBasedOnSinglePoint<StringBuilder> {
    RediSearchGeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
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
