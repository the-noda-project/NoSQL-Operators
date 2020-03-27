package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

final class OperatorInGeoRectangle extends GeoSpatialOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

}
