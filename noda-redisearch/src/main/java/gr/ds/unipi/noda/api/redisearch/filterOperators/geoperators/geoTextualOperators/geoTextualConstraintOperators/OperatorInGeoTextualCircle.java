package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;

public class OperatorInGeoTextualCircle extends GeoTextualConstraintOperator<Node, Circle> {
    protected OperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        super(GeographicalOperator.geoSpatialOperator.newOperatorInGeoCircle(fieldName,circle), conditionalTextualOperator);
    }

    @Override
    public Node getOperatorExpression() {
        return QueryBuilder.intersect((Node) getConditionalTextualOperator().getOperatorExpression(), (Node) getGeographicalOperator().getOperatorExpression());
    }

    public static OperatorInGeoTextualCircle inGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator){
        return new OperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }
}
