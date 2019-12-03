package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import redis.clients.jedis.Jedis;

class OperatorInGeographicalBox extends GeographicalOperatorBasedOnPoints {
    private final static String LOWER_BOUND_NAME = "lowerBound";
    private final static String UPPER_BOUND_NAME = "upperBound";
    private final static String TEMP_ZSET_NAME = "tempSet";
    private final static String GEO_KEY_PREFIX = "geo:";

    private OperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        super(fieldName, new Coordinates[]{lowerBound, upperBound});
    }

    static OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalBox(fieldName, lowerBound, upperBound);
    }

    protected ZRangeInfo getOperatorField(Jedis jedis, String index) {
        jedis.geoadd(TEMP_ZSET_NAME, getCoordinatesArray()[0].getLongitude(), getCoordinatesArray()[0].getLatitude(), LOWER_BOUND_NAME);
        jedis.geoadd(TEMP_ZSET_NAME, getCoordinatesArray()[1].getLongitude(), getCoordinatesArray()[1].getLatitude(), UPPER_BOUND_NAME);
        Double lowerBoundScore = jedis.zscore(TEMP_ZSET_NAME, LOWER_BOUND_NAME);
        Double upperBoundScore = jedis.zscore(TEMP_ZSET_NAME, UPPER_BOUND_NAME);
        ZRangeInfo zRangeInfo = ZRangeInfo.of(GEO_KEY_PREFIX + index + StringPool.FORWARD_SLASH + getFieldName(), lowerBoundScore, upperBoundScore);
        jedis.zrem(TEMP_ZSET_NAME, LOWER_BOUND_NAME, UPPER_BOUND_NAME);
        return zRangeInfo;
    }
}
