package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

    @Override
    protected String getEvalExpression() {
        return null;
    }

    @Override
    protected String[] getArgvArray() {
        return new String[]{getMatchingPattern(), "longitude", "latitude", String.valueOf(getGeometry().getCircleCenter().getLongitude()), String.valueOf(getGeometry().getCircleCenter().getLatitude()), String.valueOf(getGeometry().getRadius())};
    }

}