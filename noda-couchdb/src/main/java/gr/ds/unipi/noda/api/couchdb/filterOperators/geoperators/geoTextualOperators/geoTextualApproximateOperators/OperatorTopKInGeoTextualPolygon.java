package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;

import java.util.Collection;
import java.util.Map;

public class OperatorTopKInGeoTextualPolygon extends GeoTextualApproximateOperator<Polygon> {
    private final int topK;

    protected OperatorTopKInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon),
                keywordFieldName,
                keywords.toArray(new String[0])
        );
        this.topK = topK;
    }

    public static OperatorTopKInGeoTextualPolygon newOperatorTopKInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        return new OperatorTopKInGeoTextualPolygon(fieldName, polygon, keywordFieldName, keywords, topK);
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
