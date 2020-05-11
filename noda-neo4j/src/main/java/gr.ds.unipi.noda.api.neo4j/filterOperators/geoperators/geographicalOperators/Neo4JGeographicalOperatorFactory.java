package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class Neo4JGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {

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
