package gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

class OperatorInGeographicalCircle extends GeoSpatialOperator<Circle> {

    private OperatorInGeographicalCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeographicalCircle(fieldName, circle);
    }


    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}