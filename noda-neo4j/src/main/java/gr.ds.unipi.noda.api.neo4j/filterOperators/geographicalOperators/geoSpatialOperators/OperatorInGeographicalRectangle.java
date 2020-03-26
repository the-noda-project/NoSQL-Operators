package gr.ds.unipi.noda.api.neo4j.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

final class OperatorInGeographicalRectangle extends GeoSpatialOperator<Rectangle> {

    private OperatorInGeographicalRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeographicalRectangle newOperatorInGeographicalRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeographicalRectangle(fieldName, rectangle);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }

}
