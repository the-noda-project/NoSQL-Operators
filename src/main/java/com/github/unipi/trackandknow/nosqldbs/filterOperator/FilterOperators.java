package com.github.unipi.trackandknow.nosqldbs.filterOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator.*;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.*;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.logicalOperator.OperatorAnd;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.logicalOperator.OperatorOr;

public class FilterOperators {

    public static FilterOperator and(FilterOperator... filterOperator) {
        return OperatorAnd.newOperatorAnd(filterOperator);
    }

    public static FilterOperator or(FilterOperator... filterOperator) {
        return OperatorOr.newOperatorOr(filterOperator);
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

    public static FilterOperator inGeoPolygon(String fieldName, Coordinates... coordinates) {
        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, coordinates);
    }

    public static FilterOperator inGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerBoundPoint, upperBoundPoint);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius/6378.1);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius/6378100);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius/3963.2);
    }

    public static FilterOperator nearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, point, neighbors);
    }
}
