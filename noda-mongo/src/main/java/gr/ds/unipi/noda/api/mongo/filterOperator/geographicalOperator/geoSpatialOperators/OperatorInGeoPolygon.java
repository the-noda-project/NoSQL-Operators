package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;

class OperatorInGeoPolygon extends GeoSpatialOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);

    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return getOperatorExpressionForPolygonAndRectangle();
    }
}
