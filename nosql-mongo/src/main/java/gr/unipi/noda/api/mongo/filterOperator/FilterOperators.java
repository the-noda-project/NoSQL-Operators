package gr.unipi.noda.api.mongo.filterOperator;

import gr.unipi.noda.api.core.operators.FilterOperator;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.unipi.noda.api.mongo.filterOperator.comparisonOperator.*;
import gr.unipi.noda.api.mongo.filterOperator.geographicalOperator.OperatorInGeographicalCircle;
import gr.unipi.noda.api.mongo.filterOperator.geographicalOperator.OperatorInGeographicalPolygon;
import gr.unipi.noda.api.mongo.filterOperator.geographicalOperator.OperatorInGeographicalRectangle;
import gr.unipi.noda.api.mongo.filterOperator.geographicalOperator.OperatorNearestNeighbors;
import gr.unipi.noda.api.mongo.filterOperator.logicalOperator.OperatorAnd;
import gr.unipi.noda.api.mongo.filterOperator.logicalOperator.OperatorOr;

import java.util.Date;

public class FilterOperators {

    public static FilterOperator and(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorAnd.newOperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    public static FilterOperator or(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorOr.newOperatorOr(filterOperator1, filterOperator2, filterOperators);
    }

    public static FilterOperator gte(String fieldName, double fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, int fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, float fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, short fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, long fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, Date fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, double fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, int fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, float fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, short fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, long fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, Date fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, double fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, int fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, float fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, short fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, long fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, Date fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, double fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, int fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, float fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, short fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, long fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, Date fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, double fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, boolean fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, String fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, int fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, float fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, short fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, long fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, Date fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, double fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, boolean fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, String fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, int fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, float fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, short fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, long fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, Date fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    public static FilterOperator inGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, coordinates1, coordinates2, coordinates3, coordinates);
    }

    public static FilterOperator inGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalRectangle.newOperatorInGeographicalBox(fieldName, lowerBoundPoint, upperBoundPoint);
    }

    public static FilterOperator inGeoCircleKm(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius * 1000);
    }

    public static FilterOperator inGeoCircleMeters(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius);
    }

    public static FilterOperator inGeoCircleMiles(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius * 1609.344);
    }

    public static FilterOperator nearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, point, neighbors);
    }
}
