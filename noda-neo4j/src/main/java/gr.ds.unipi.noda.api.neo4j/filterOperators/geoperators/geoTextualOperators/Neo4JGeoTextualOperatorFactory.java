package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualCircle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualPolygon;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualRectangle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualCircle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualPolygon;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.OperatorInGeoTextualRectangle;

import java.util.Collection;

public final class Neo4JGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualRectangle.newOperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualCircle.newOperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
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
