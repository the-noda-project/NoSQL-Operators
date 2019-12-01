package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.redis.RedisConnectionManager;
import gr.ds.unipi.noda.api.redis.RedisConnector;
import redis.clients.jedis.Jedis;

class OperatorInGeographicalRectangle extends GeographicalOperatorBasedOnPoints {
    private final ZRangeInfo zRangeInfo;

    public OperatorInGeographicalRectangle(String fieldName, Coordinates lowerBound,
                                           Coordinates upperBound, Double lowerBoundScore, Double upperBoundScore) {
        super(fieldName, new Coordinates[]{lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude())});
        zRangeInfo = ZRangeInfo.of("geo:"+RedisConnector.getRedisConnector().getIndexName()+"/"+getFieldName(),
                lowerBoundScore, upperBoundScore);
    }

    public static OperatorInGeographicalRectangle newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        Jedis jedis = RedisConnectionManager.getInstance().getConnection(RedisConnector.getRedisConnector())._conn();
        jedis.geoadd(fieldName, lowerBound.getLongitude(), lowerBound.getLatitude(), "lowerBound");
        jedis.geoadd(fieldName, upperBound.getLongitude(), upperBound.getLatitude(), "upperBound");

        Double lowerBound1 = jedis.zscore(fieldName, "lowerBound");
        Double upperBound1 =jedis.zscore(fieldName, "upperBound");
        return new OperatorInGeographicalRectangle(fieldName, lowerBound, upperBound, lowerBound1, upperBound1);
    }

    @Override
    protected ZRangeInfo getOperatorField() {
        return zRangeInfo;
    }
}
