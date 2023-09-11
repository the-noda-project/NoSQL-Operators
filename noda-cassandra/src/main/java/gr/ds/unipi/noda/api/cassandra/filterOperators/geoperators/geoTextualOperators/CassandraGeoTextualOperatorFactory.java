package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualCircle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualPolygon;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualRectangle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualCircle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualPolygon;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualRectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

import java.util.Collection;

public final class CassandraGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator inGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualRectangle.newOperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator inGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualCircle.newOperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator inGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualPolygon.newOperatorInGeoTextualPolygon(fieldName, polygon, conditionalTextualOperator);
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK) {
        return OperatorTopKInGeoTextualRectangle.newOperatorTopKInGeoTextualRectangle(fieldName, rectangle, keywordFieldName, keywords, topK);
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        return OperatorTopKInGeoTextualCircle.newOperatorTopKInGeoTextualCircle(fieldName, circle, keywordFieldName, keywords, topK);
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        return OperatorTopKInGeoTextualPolygon.newOperatorTopKInGeoTextualPolygon(fieldName, polygon, keywordFieldName, keywords, topK);
    }
}
