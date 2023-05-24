package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

import java.util.Collection;
import java.util.Map;

public class OperatorTopKInGeoTextualCircle extends GeoTextualApproximateOperator<Circle> {
    private final int topK;

    protected OperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle),
                keywordFieldName,
                keywords.toArray(new String[0])
        );
        this.topK = topK;
    }

    public static OperatorTopKInGeoTextualCircle newOperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        return new OperatorTopKInGeoTextualCircle(fieldName, circle, keywordFieldName, keywords, topK);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                return null;
            }

            @Override
            public Map<String, Object> asFindFilter() {
                return null;
            }
        };
    }
}
