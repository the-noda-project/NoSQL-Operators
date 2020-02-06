package gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnSinglePoint {

    private final double radius;//radius is in meters

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        super(fieldName, point);
        this.radius = radius;
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        return new OperatorInGeographicalCircle(fieldName, point, radius);
    }

    @Override
    public T getOperatorExpression() {
        return null;
    }

}