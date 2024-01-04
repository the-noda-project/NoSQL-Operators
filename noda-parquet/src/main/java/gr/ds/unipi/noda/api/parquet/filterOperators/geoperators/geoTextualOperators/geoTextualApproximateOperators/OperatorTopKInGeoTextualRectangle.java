package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;

import java.util.Collection;

public class OperatorTopKInGeoTextualRectangle extends GeoTextualApproximateOperator<Rectangle> {
    private final int topK;

    protected OperatorTopKInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName,rectangle), keywordFieldName, keywords.toArray(new String[0]));
        this.topK = topK;
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorTopKInGeoTextualRectangle newOperatorTopKInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK){
        return new OperatorTopKInGeoTextualRectangle(fieldName, rectangle, keywordFieldName, keywords, topK);
    }
}
