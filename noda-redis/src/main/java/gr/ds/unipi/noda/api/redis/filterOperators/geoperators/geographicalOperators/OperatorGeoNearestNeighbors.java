package gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;

final class OperatorGeoNearestNeighbors extends GeographicalOperator<Point> {

    private final int neighbors;

    private OperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorGeoNearestNeighbors newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return new OperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    @Override
    protected String getEvalExpression() {
        return null;
    }

    @Override
    protected String[] getArgvArray(String range) {
        return new String[0];
    }
}
