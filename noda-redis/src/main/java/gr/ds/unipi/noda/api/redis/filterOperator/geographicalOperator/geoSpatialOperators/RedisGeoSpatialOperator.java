package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.geoSpatialOperators;

import redis.clients.jedis.Jedis;
import java.util.function.BiFunction;

/**
 * @author adimo on 3/12/2019
 */
public interface RedisGeoSpatialOperator {
    BiFunction<Jedis, String, ZRangeInfo> getZRangeInfo();
}
