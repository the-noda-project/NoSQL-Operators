package gr.ds.unipi.noda.api.neo4j.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;

final class OperatorInGeographicalPolygon extends GeoSpatialOperator<Polygon> {

    private OperatorInGeographicalPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    public static OperatorInGeographicalPolygon newOperatorInGeographicalPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeographicalPolygon(fieldName, polygon);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}
