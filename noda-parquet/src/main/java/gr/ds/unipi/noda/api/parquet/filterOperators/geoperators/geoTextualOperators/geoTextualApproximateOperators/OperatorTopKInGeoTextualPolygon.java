package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;

import java.util.Collection;

public class OperatorTopKInGeoTextualPolygon extends GeoTextualApproximateOperator<Polygon> {
    private final int topK;

    protected OperatorTopKInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), keywordFieldName, keywords.toArray(new String[0]));
        this.topK= topK;
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorTopKInGeoTextualPolygon newOperatorTopKInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK){
        return new OperatorTopKInGeoTextualPolygon(fieldName, polygon, keywordFieldName, keywords, topK);
    }
}
