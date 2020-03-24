package gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.RediSearchUnitMap;

/**
 * @author adimo on 11/10/2019
 */
class OperatorInGeoCircle extends GeoSpatialOperator<Circle> {
    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getGeometry().getCircleCenter().getLongitude()
                + StringPool.SPACE + getGeometry().getCircleCenter().getLatitude() + StringPool.SPACE
                + getGeometry().getRadius() + StringPool.SPACE + RediSearchUnitMap.getUnitString(getGeometry().getUnit()) + StringPool.CLOSE_BRACKET;
    }

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    static OperatorInGeoCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }
}
