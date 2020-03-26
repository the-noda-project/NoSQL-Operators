package gr.ds.unipi.noda.api.neo4j.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

public final class Neo4JGeoSpatialOperatorFactory extends BaseGeoSpatialOperatorFactory {

    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, polygon);
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return OperatorInGeographicalRectangle.newOperatorInGeographicalRectangle(fieldName, rectangle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }
}
