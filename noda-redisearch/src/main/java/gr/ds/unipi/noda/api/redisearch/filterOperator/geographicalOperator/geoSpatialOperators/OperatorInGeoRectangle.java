package gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;
import org.apache.commons.lang3.NotImplementedException;
import redis.clients.jedis.Jedis;

import java.util.function.BiFunction;

class OperatorInGeoRectangle extends GeoSpatialOperator<Rectangle> implements RediSearchGeoSpatialOperator {
    private final static String LOWER_BOUND_NAME = "lowerBound";
    private final static String UPPER_BOUND_NAME = "upperBound";
    private final static String TEMP_ZSET_NAME = "tempSet";
    private final static String GEO_KEY_PREFIX = "geo:";

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    static OperatorInGeoRectangle newOperatorInGeographicalRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    protected String getOperatorField() {
        throw new NotImplementedException("Not needed for Rectangle search.");
    }

    @Override
    public StringBuilder getOperatorExpression() {
        throw new UnsupportedOperationException("Not supported for RediSearch GeoRectangle");
    }

    @Override
    public BiFunction<Jedis, String, ZRangeInfo> getZRangeInfo() {
        return (jedis, index) -> {
            jedis.geoadd(TEMP_ZSET_NAME, getGeometry().getLowerBound().getLongitude(), getGeometry().getLowerBound().getLatitude(), LOWER_BOUND_NAME);
            jedis.geoadd(TEMP_ZSET_NAME, getGeometry().getUpperBound().getLongitude(), getGeometry().getUpperBound().getLatitude(), UPPER_BOUND_NAME);
            Double lowerBoundScore = jedis.zscore(TEMP_ZSET_NAME, LOWER_BOUND_NAME);
            Double upperBoundScore = jedis.zscore(TEMP_ZSET_NAME, UPPER_BOUND_NAME);
            ZRangeInfo zRangeInfo = ZRangeInfo.of(GEO_KEY_PREFIX + index + StringPool.FORWARD_SLASH + getFieldName(), lowerBoundScore, upperBoundScore);
            jedis.zrem(TEMP_ZSET_NAME, LOWER_BOUND_NAME, UPPER_BOUND_NAME);
            return zRangeInfo;
        };
    }
}
