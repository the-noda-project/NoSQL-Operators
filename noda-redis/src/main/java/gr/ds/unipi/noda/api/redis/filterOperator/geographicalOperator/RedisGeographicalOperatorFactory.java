package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;

/**
 * @author adimo on 11/10/2019
 */
public class RedisGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        throw new UnsupportedOperationException("InGeoPolygon primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        throw new UnsupportedOperationException("InGeoBox primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.km);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.m);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.mi);
    }

    @Override
    public GeographicalOperator newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighborsCount) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, point, neighborsCount);
    }

    public static boolean isOperatorNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorNearestNeighbors;
    }
}
