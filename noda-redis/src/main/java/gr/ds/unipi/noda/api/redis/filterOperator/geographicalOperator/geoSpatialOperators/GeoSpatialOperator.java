package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import redis.clients.jedis.Jedis;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator<StringBuilder, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    public enum Unit {
        m, km, mi, ft
    }

    protected abstract String getOperatorField();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringPool.AT).append(getFieldName()).append(StringPool.COLON).append(getOperatorField());
        return sb;
    }
}
