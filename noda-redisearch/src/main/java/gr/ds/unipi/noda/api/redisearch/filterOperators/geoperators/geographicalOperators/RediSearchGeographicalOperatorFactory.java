package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

import java.util.function.Predicate;

/**
 * @author adimo on 11/10/2019
 */
public final class RediSearchGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        throw new UnsupportedOperationException("InGeoPolygon primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Circle circle) {
        return OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Circle circle) {
        return OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Circle circle) {
        return OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    public static boolean isOperatorGeoNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorGeoNearestNeighbors;
    }

    public static boolean isOperatorGeoBox(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorInGeoRectangle;
    }

    public static boolean isOperatorGeoCircle(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorInGeoCircle;
    }

    public static boolean isOperatorGeoRectangle(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorInGeoRectangle;
    }

    public static Predicate<FilterOperator> isGeo = filterOperator -> isOperatorGeoBox(filterOperator) || isOperatorGeoCircle(filterOperator)
            || isOperatorGeoNearestNeighbor(filterOperator) || isOperatorGeoRectangle(filterOperator);
}
