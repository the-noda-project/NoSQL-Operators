package gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

class OperatorGeoNearestNeighbors extends GeographicalOperatorBasedOnSinglePoint {

    private final int neighbors;

    private OperatorGeoNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorGeoNearestNeighbors newOperatorGeoNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return new OperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    @Override
    public T getOperatorExpression() {

        return null;

    }

}
