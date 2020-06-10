package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

import java.util.Collection;

public class OperatorTopKInGeoTextualCircle extends GeoTextualApproximateOperator<StringBuilder, Circle>{
    private final int topK;

    protected OperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), keywordFieldName, keywords.toArray(new String[0]));
        this.topK= topK;
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }

    public static OperatorTopKInGeoTextualCircle newOperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK){
        return new OperatorTopKInGeoTextualCircle(fieldName, circle, keywordFieldName, keywords, topK);
    }
}
