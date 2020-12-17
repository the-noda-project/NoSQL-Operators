package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;


import java.util.Collection;

public abstract class BaseGeoTextualOperatorFactory {

    public abstract GeoTextualConstraintOperator newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator);

    public abstract GeoTextualConstraintOperator newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator);

    public abstract GeoTextualConstraintOperator newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator);

    public abstract GeoTextualApproximateOperator topRankInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK);

    public abstract GeoTextualApproximateOperator topRankInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK);

    public abstract GeoTextualApproximateOperator topRankInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK);


}
