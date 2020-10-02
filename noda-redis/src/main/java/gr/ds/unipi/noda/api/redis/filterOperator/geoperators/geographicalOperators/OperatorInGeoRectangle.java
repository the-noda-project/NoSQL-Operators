package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    @Override
    protected String getEvalExpression() {
        return null;
    }

    @Override
    protected String[] getArgvArray() {
        return new String[]{getMatchingPattern(), "longitude", "latitude", String.valueOf(getGeometry().getLowerBound().getLongitude()), String.valueOf(getGeometry().getUpperBound().getLongitude()), String.valueOf(getGeometry().getLowerBound().getLatitude()), String.valueOf(getGeometry().getUpperBound().getLatitude())};
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

}
