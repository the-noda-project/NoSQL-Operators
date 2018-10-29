package com.github.unipi.trackandknow.nosqldbs.filteroperator;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison.*;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical.OperatorInGeographicalBox;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.logical.OperatorAnd;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.logical.OperatorOr;

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

    public static FilterOperator inGeoBox(String fieldName, double lowerLon, double lowerLat, double upperLon, double upperLat) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLon, lowerLat, upperLon, upperLat);
    }

    public static FilterOperator inGeoBox(String fieldName, int lowerLon, int lowerLat, int upperLon, int upperLat) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLon, lowerLat, upperLon, upperLat);
    }

    public static FilterOperator inGeoBox(String fieldName, float lowerLon, float lowerLat, float upperLon, float upperLat) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLon, lowerLat, upperLon, upperLat);
    }

    public static FilterOperator inGeoBox(String fieldName, short lowerLon, short lowerLat, short upperLon, short upperLat) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLon, lowerLat, upperLon, upperLat);
    }

    public static FilterOperator inGeoBox(String fieldName, long lowerLon, long lowerLat, long upperLon, long upperLat) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLon, lowerLat, upperLon, upperLat);
    }

}
