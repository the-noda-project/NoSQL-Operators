package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualCircle;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualCircle;

import java.util.Collection;

public final class RediSearchGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator  newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        throw new UnsupportedOperationException("inGeoTextualRectangle primitive is not supported");
    }

    @Override
    public GeoTextualConstraintOperator  newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualCircle.newOperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator  newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        throw new UnsupportedOperationException("inGeoTextualPolygon primitive is not supported");
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK) {
        throw new UnsupportedOperationException("topRankInGeoTextualRectangle primitive is not supported");
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        return OperatorTopKInGeoTextualCircle.newOperatorTopKInGeoTextualCircle(fieldName, circle, keywordFieldName, keywords, topK);
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        throw new UnsupportedOperationException("topRankInGeoTextualPolygon primitive is not supported");
    }
}
