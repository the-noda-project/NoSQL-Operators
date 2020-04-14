package gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Value;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator<Node, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    protected abstract Value getOperatorField();

    @Override
    public Node getOperatorExpression() {
        return QueryBuilder.intersect(getFieldName(), getOperatorField());
    }
}
