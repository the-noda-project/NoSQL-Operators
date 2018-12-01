package com.github.unipi.trackandknow.nosqldbs.filterOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator.*;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.OperatorInGeographicalBox;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.OperatorInGeographicalRange;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.OperatorNearestNeighbors;
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

    public static FilterOperator inGeoBox(String fieldName, double lowerLongitude, double lowerLatitude, double upperLongitude, double upperLatitude) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static FilterOperator inGeoBox(String fieldName, int lowerLongitude, int lowerLatitude, int upperLongitude, int upperLatitude) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static FilterOperator inGeoBox(String fieldName, float lowerLongitude, float lowerLatitude, float upperLongitude, float upperLatitude) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static FilterOperator inGeoBox(String fieldName, short lowerLongitude, short lowerLatitude, short upperLongitude, short upperLatitude) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static FilterOperator inGeoBox(String fieldName, long lowerLongitude, long lowerLatitude, long upperLongitude, long upperLatitude) {
        return OperatorInGeographicalBox.newOperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, double longitude, double latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378.1);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, int longitude, int latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378.1);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, float longitude, float latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378.1);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, short longitude, short latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378.1);
    }

    public static FilterOperator inGeoRangeKm(String fieldName, long longitude, long latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378.1);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, double longitude, double latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378100);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, int longitude, int latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378100);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, float longitude, float latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378100);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, short longitude, short latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378100);
    }

    public static FilterOperator inGeoRangeMeters(String fieldName, long longitude, long latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/6378100);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, double longitude, double latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/3963.2);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, int longitude, int latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/3963.2);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, float longitude, float latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/3963.2);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, short longitude, short latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/3963.2);
    }

    public static FilterOperator inGeoRangeMiles(String fieldName, long longitude, long latitude, double radius) {
        return OperatorInGeographicalRange.newOperatorInGeographicalRange(fieldName, longitude, latitude, radius/3963.2);
    }

    public static FilterOperator nearestNeighbors(String fieldName, double longitude, double latitude, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    public static FilterOperator nearestNeighbors(String fieldName, int longitude, int latitude, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    public static FilterOperator nearestNeighbors(String fieldName, float longitude, float latitude, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    public static FilterOperator nearestNeighbors(String fieldName, short longitude, short latitude, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    public static FilterOperator nearestNeighbors(String fieldName, long longitude, long latitude, int neighbors) {
        return OperatorNearestNeighbors.newOperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }


















}
