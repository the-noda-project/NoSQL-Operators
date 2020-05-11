package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Value;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<Node, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    protected abstract Value getOperatorField();

    @Override
    public Node getOperatorExpression() {
        return QueryBuilder.intersect(getFieldName(), getOperatorField());
    }
}
