package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators;

import redis.clients.jedis.Jedis;

import java.util.function.BiFunction;

/**
 * @author adimo on 3/12/2019
 */
public interface RediSearchGeographicalOperator {
    BiFunction<Jedis, String, ZRangeInfo> getZRangeInfo();
}
