package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

import java.util.Collection;

public final class RedisGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator  newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return null;
    }

    @Override
    public GeoTextualConstraintOperator newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return null;
    }

    @Override
    public GeoTextualConstraintOperator newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }
}
