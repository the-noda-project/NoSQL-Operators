package gr.ds.unipi.noda.api.core.operators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.RoadNetworkOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.RoadNetworkGeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

import java.util.Collection;
import java.util.Date;

public class FilterOperators {

    public static FilterOperator and(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return LogicalOperator.logicalOperator.newOperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    public static FilterOperator or(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return LogicalOperator.logicalOperator.newOperatorOr(filterOperator1, filterOperator2, filterOperators);
    }

    public static FilterOperator gte(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gte(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGte(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator gt(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorGt(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lte(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLte(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator lt(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorLt(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, boolean fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, String fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator eq(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorEq(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, double fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, boolean fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, String fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, int fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, float fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, short fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, long fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator ne(String fieldName, Date fieldValue) {
        return ComparisonOperator.comparisonOperator.newOperatorNe(fieldName, fieldValue);
    }

    public static FilterOperator inGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return GeographicalOperator.geoSpatialOperator.newOperatorInGeoPolygon(fieldName, Polygon.newPolygon(coordinates1, coordinates2, coordinates3, coordinates));
    }

    public static FilterOperator inGeoRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return GeographicalOperator.geoSpatialOperator.newOperatorInGeoRectangle(fieldName, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint));
    }

    public static FilterOperator inGeoCircleKm(String fieldName, Coordinates point, double radius) {
        return GeographicalOperator.geoSpatialOperator.newOperatorInGeoCircle(fieldName, Circle.newCircle(point, radius * 1000));
    }

    public static FilterOperator inGeoCircleMeters(String fieldName, Coordinates point, double radius) {
        return GeographicalOperator.geoSpatialOperator.newOperatorInGeoCircle(fieldName, Circle.newCircle(point, radius));
    }

    public static FilterOperator inGeoCircleMiles(String fieldName, Coordinates point, double radius) {
        return GeographicalOperator.geoSpatialOperator.newOperatorInGeoCircle(fieldName, Circle.newCircle(point, radius * 1609.344));
    }

    public static FilterOperator geoNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return GeographicalOperator.geoSpatialOperator.newOperatorGeoNearestNeighbors(fieldName, Point.newPoint(point), neighbors);
    }

    public static FilterOperator inGeoTemporalPolygon(String fieldName, String fieldTemporalName, Date lowerBoundDate, Date upperBoundDate, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorInGeoTemporalPolygon(fieldName, Polygon.newPolygon(coordinates1, coordinates2, coordinates3, coordinates), fieldTemporalName, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator inGeoTemporalRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint, String fieldTemporalName, Date lowerBoundDate, Date upperBoundDate) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorInGeoTemporalRectangle(fieldName, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint), fieldTemporalName, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator inGeoTemporalCircleKm(String fieldName, Coordinates point, double radius, String fieldTemporalName, Date lowerBoundDate, Date upperBoundDate) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorInGeoTemporalCircleKm(fieldName, Circle.newCircle(point, radius * 1000), fieldTemporalName, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator inGeoTemporalCircleMeters(String fieldName, Coordinates point, double radius, String fieldTemporalName, Date lowerBoundDate, Date upperBoundDate) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorInGeoTemporalCircleMeters(fieldName, Circle.newCircle(point, radius), fieldTemporalName, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator inGeoTemporalCircleMiles(String fieldName, Coordinates point, double radius, String fieldTemporalName, Date lowerBoundDate, Date upperBoundDate) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorInGeoTemporalCircleMiles(fieldName, Circle.newCircle(point, radius * 1609.344), fieldTemporalName, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator geoTemporalNearestNeighbors(String fieldName, Coordinates point, String fieldTemporalName, Date date, int neighbors) {
        return GeoTemporalOperator.geoTemporalOperator.newOperatorGeoTemporalNearestNeighbors(fieldName, Point.newPoint(point), neighbors);
    }

    public static ConditionalTextualOperator anyKeywords(String fieldName, String keyword, String... keywords) {
        return TextualOperator.textualOperator.newOperatorAnyKeywords(fieldName, keyword, keywords);
    }

    public static ConditionalTextualOperator allKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return TextualOperator.textualOperator.newOperatorAllKeywords(fieldName, keyword1, keyword2, keywords);
    }

    public static FilterOperator inGeoTextualRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint, ConditionalTextualOperator conditionalTextualOperator) {
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualRectangle(fieldName, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint), conditionalTextualOperator);
    }

    public static FilterOperator inGeoTextualCircleKm(String fieldName, Coordinates point, double radius, ConditionalTextualOperator conditionalTextualOperator) {
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualCircle(fieldName, Circle.newCircle(point, radius * 1000), conditionalTextualOperator);
    }

    public static FilterOperator inGeoTextualCircleMeters(String fieldName, Coordinates point, double radius, ConditionalTextualOperator conditionalTextualOperator) {
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualCircle(fieldName, Circle.newCircle(point, radius), conditionalTextualOperator);
    }

    public static FilterOperator inGeoTextualCircleMiles(String fieldName, Coordinates point, double radius, ConditionalTextualOperator conditionalTextualOperator) {
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualCircle(fieldName, Circle.newCircle(point, radius * 1609.344), conditionalTextualOperator);
    }

    public static FilterOperator inGeoTextualPolygon(String fieldName, ConditionalTextualOperator conditionalTextualOperator, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualPolygon(fieldName, Polygon.newPolygon(coordinates1, coordinates2, coordinates3, coordinates), conditionalTextualOperator);

    }

    public static FilterOperator topRankInGeoTextualRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint, String keywordFieldName, Collection<String> keywords, int topK) {
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualRectangle(fieldName, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint), keywordFieldName, keywords, topK);

    }

    public static FilterOperator topRankInGeoTextualCircleKm(String fieldName, Coordinates point, double radius, String keywordFieldName, Collection<String> keywords, int topK) {
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualCircle(fieldName, Circle.newCircle(point, radius * 1000), keywordFieldName, keywords, topK);
    }

    public static FilterOperator topRankInGeoTextualCircleMeters(String fieldName, Coordinates point, double radius, String keywordFieldName, Collection<String> keywords, int topK) {
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualCircle(fieldName, Circle.newCircle(point, radius), keywordFieldName, keywords, topK);
    }

    public static FilterOperator topRankInGeoTextualCircleMiles(String fieldName, Coordinates point, double radius, String keywordFieldName, Collection<String> keywords, int topK) {
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualCircle(fieldName, Circle.newCircle(point, radius * 1609.344), keywordFieldName, keywords, topK);
    }

    public static FilterOperator topRankInGeoTextualPolygon(String fieldName, String keywordFieldName, Collection<String> keywords, int topK, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualPolygon(fieldName, Polygon.newPolygon(coordinates1, coordinates2, coordinates3, coordinates), keywordFieldName, keywords, topK);
    }

    public static FilterOperator nearestInRangeInRoadNetwork(String locationField, Point point, double distance, String temporalField, Date lowerBoundDate, Date upperBoundDate) {
        return RoadNetworkOperator.roadNetworkOperator.newOperatorRoadNetworkNearest(locationField, point, distance, temporalField, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }
    public static FilterOperator nearestObjectInRoadNetwork(String locationField, Point point, String temporalField, Date lowerBoundDate, Date upperBoundDate) {
        return RoadNetworkOperator.roadNetworkOperator.newOperatorRoadNetworkNearestObject(locationField, point, temporalField, TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }
    public static FilterOperator shortestPathInRoadNetwork(String locationField, Point point1, Point point2) {
        return RoadNetworkOperator.roadNetworkOperator.newOperatorRoadNetworkShortestPath(locationField, point1, point2);
    }

    public static FilterOperator trajectoriesInGeoTemporalRectangle(String objectIdField, String segmentField, Coordinates lowerBoundPoint, Coordinates upperBoundPoint, Date lowerBoundDate, Date upperBoundDate) {
        return TrajectoryOperator.trajectoryOperator.newOperatorTrajectoriesInGeoTemporalRectangle(objectIdField, segmentField, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint), TemporalBounds.newTemporalBounds(lowerBoundDate, upperBoundDate));
    }

    public static FilterOperator trajectoriesinGeoRectangle(String objectIdField, String segmentField, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        return TrajectoryOperator.trajectoryOperator.newOperatorTrajectoriesInGeoRectangle(objectIdField, segmentField, Rectangle.newRectangle(lowerBoundPoint, upperBoundPoint));
    }

}
