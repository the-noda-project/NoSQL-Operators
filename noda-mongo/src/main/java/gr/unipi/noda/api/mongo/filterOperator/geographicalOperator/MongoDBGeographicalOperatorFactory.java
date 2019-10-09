package gr.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;

public class MongoDBGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {

    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, coordinates1, coordinates2, coordinates3, coordinates);
    }

    @Override
    public GeographicalOperator newOperatorInGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalRectangle.newOperatorInGeographicalBox(fieldName, lowerBoundPoint, upperBoundPoint);
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
    public GeographicalOperator newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, point, neighbors);
    }

    public static boolean isOperatorNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorNearestNeighbors;
    }
}
