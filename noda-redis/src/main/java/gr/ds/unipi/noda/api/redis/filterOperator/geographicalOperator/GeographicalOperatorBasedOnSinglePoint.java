package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

/**
 * @author adimo on 11/10/2019
 */
abstract class GeographicalOperatorBasedOnSinglePoint extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnSinglePoint<StringBuilder> {
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
