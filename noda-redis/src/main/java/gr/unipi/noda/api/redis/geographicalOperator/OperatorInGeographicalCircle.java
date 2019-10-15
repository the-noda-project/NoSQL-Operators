package gr.unipi.noda.api.redis.geographicalOperator;

import gr.unipi.noda.api.redis.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

/**
 * @author adimo on 11/10/2019
 */
public class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnSinglePoint {
    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getLongitude() + StringPool.SPACE + getLatitude() + StringPool.SPACE + radius + StringPool.SPACE + unit.toString() + StringPool.CLOSE_BRACKET;
    }

    private final double radius;
    private final Unit unit;

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius, Unit unit) {
        super(fieldName, point);
        this.radius = radius;
        this.unit = unit;
    }

    static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius, Unit unit) {
        return new OperatorInGeographicalCircle(fieldName, point, radius, unit);
    }
}
