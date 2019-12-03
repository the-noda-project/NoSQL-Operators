package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import redis.clients.jedis.Jedis;

abstract class GeographicalOperatorBasedOnPoints extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnPoints<ZRangeInfo>
        implements RedisGeographicalOperatorBasedOnPoints {
    GeographicalOperatorBasedOnPoints(String fieldName, Coordinates[] coordinates) {
        super(fieldName, coordinates);
    }

    protected abstract ZRangeInfo getOperatorField(Jedis jedis, String index);

    @Override
    public ZRangeInfo getOperatorExpression() {
        throw new UnsupportedOperationException("getOperatorExpression without parameters is not supported");
    }

    public ZRangeInfo getOperatorExpression(Jedis jedis, String index) {
        return getOperatorField(jedis, index);
    }
}
