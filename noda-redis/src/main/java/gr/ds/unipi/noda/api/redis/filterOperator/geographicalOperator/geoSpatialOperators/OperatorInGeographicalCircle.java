package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

/**
 * @author adimo on 11/10/2019
 */
class OperatorInGeographicalCircle extends GeoSpatialOperator<Circle> {
    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getGeometry().getCircleCenter().getLongitude()
                + StringPool.SPACE + getGeometry().getCircleCenter().getLatitude() + StringPool.SPACE
                + getGeometry().getRadius() + StringPool.SPACE + unit.toString() + StringPool.CLOSE_BRACKET;
    }

    private final Unit unit;

    private OperatorInGeographicalCircle(String fieldName, Circle circle, Unit unit) {
        super(fieldName, circle);
        this.unit = unit;
    }

    static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle, Unit unit) {
        return new OperatorInGeographicalCircle(fieldName, circle, unit);
    }
}
