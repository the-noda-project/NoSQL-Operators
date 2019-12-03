package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import redis.clients.jedis.Jedis;

/**
 * @author adimo on 3/12/2019
 */
public interface RedisGeographicalOperatorBasedOnPoints {
    ZRangeInfo getOperatorExpression(Jedis jedis, String index);
}
