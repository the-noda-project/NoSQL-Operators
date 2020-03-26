package gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators;

import redis.clients.jedis.Jedis;

import java.util.function.BiFunction;

/**
 * @author adimo on 3/12/2019
 */
public interface RediSearchGeoSpatialOperator {
    BiFunction<Jedis, String, ZRangeInfo> getZRangeInfo();
}
