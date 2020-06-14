package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Value;
import io.redisearch.querybuilder.Values;

import java.util.Arrays;
import java.util.Collection;

public class OperatorTopKInGeoTextualCircle extends GeoTextualApproximateOperator<Node, Circle>{
    private final int topK;

    protected OperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        super(GeographicalOperator.geoSpatialOperator.newOperatorInGeoCircle(fieldName, circle), keywordFieldName, keywords.toArray(new String[0]));
        this.topK= topK;
    }

    @Override
    public Node getOperatorExpression() {
        return QueryBuilder.intersect((Node) getGeographicalOperator().getOperatorExpression(),
                QueryBuilder.intersect(getFieldName(), Arrays.stream(getKeywords()).map(Values::value).toArray(Value[]::new)));
    }

    public static OperatorTopKInGeoTextualCircle newOperatorTopKInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK){
        return new OperatorTopKInGeoTextualCircle(fieldName, circle, keywordFieldName, keywords, topK);
    }

    public int getTopK() {
        return topK;
    }
}
