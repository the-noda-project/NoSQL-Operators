package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;

final class OperatorGeoNearestNeighbors extends GeoSpatialOperator<Point> {

    private final int neighbors;

    private OperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorGeoNearestNeighbors newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return new OperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

}
