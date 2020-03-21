package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.RedisUnitMap;

/**
 * @author adimo on 11/10/2019
 */
class OperatorInGeographicalCircle extends GeoSpatialOperator<Circle> {
    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getGeometry().getCircleCenter().getLongitude()
                + StringPool.SPACE + getGeometry().getCircleCenter().getLatitude() + StringPool.SPACE
                + getGeometry().getRadius() + StringPool.SPACE + RedisUnitMap.getUnitString(getGeometry().getUnit()) + StringPool.CLOSE_BRACKET;
    }

    private OperatorInGeographicalCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeographicalCircle(fieldName, circle);
    }
}
