package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.approximateTextualOperators.ApproximateTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class BaseGeoTextualOperatorFactory {

    public abstract ConditionalTextualOperator inGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator){
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    };

    public abstract ConditionalTextualOperator inGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator){
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualCircle(fieldName, circle,conditionalTextualOperator);
    };

    public abstract ConditionalTextualOperator inGeoTextualPolygon(String fieldName, ConditionalTextualOperator conditionalTextualOperator, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates){
        return GeoTextualConstraintOperator.geoTextualOperator.inGeoTextualPolygon(fieldName,Polygon.newPolygon(coordinates1,coordinates2,coordinates3,coordinates),conditionalTextualOperator);

    };

    public abstract ApproximateTextualOperator topRankInGeoTextualRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint, String keywordFieldName, Collection<String> keywords, int topK){
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualRectangle(fieldName,Rectangle.newRectangle(lowerBoundPoint,upperBoundPoint), keywordFieldName,  keywords, topK);

    };

    public abstract ApproximateTextualOperator topRankInGeoTextualCircle(String fieldName, Coordinates point, double radius, String keywordFieldName, Collection<String> keywords, int topK){
        return GeoTextualApproximateOperator.geoTextualOperator.topRankInGeoTextualCircle(fieldName,Circle.newCircle(point,radius), keywordFieldName, keywords, topK);

    };

    public abstract ApproximateTextualOperator topRankInGeoTextualPolygon(String fieldName, String keywordFieldName, Collection<String> keywords, int topK, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates){
        return GeoTextualApproximateOperator.geoTextualOperator.inGeoTextualPolygon(fieldName,Polygon.newPolygon(coordinates1,coordinates2,coordinates3,coordinates), keywordFieldName, keywords, topK);

    };


}
