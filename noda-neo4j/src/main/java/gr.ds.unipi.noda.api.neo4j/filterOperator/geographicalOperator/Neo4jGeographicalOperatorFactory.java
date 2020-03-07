package gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;

public class Neo4jGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {

    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, coordinates1, coordinates2, coordinates3, coordinates);
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalRectangle.newOperatorInGeographicalRectangle(fieldName, lowerBoundPoint, upperBoundPoint);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius * 1000);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius * 1609.344);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    public static boolean isOperatorGeoNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorGeoNearestNeighbors;
    }
}
