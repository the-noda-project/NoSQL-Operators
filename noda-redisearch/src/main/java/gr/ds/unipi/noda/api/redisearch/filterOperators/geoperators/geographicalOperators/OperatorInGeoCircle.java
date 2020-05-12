package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import io.redisearch.querybuilder.GeoValue;
import io.redisearch.querybuilder.Value;

/**
 * @author adimo on 11/10/2019
 */
final class OperatorInGeoCircle extends GeographicalOperator<Circle> {
    @Override
    protected Value getOperatorField() {
        return new GeoValue(getGeometry().getCircleCenter().getLongitude(), getGeometry().getCircleCenter().getLatitude(),
                getGeometry().getRadius(), GeoValue.Unit.METERS);
    }

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }
}
