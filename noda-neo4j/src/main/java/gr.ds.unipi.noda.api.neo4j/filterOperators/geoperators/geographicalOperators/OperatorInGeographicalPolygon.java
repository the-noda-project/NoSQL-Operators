package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;

public final class OperatorInGeographicalPolygon extends GeographicalOperator<Polygon> {

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
