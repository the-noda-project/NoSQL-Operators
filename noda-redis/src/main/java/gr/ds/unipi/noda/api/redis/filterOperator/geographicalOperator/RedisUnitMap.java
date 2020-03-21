package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import io.redisearch.Query;

import java.util.EnumMap;
import java.util.Map;

public class RedisUnitMap {
    private final static Map<Circle.Unit, String> map = new EnumMap<>(Circle.Unit.class);

    static {
        map.putIfAbsent(Circle.Unit.M, Query.GeoFilter.METERS);
        map.putIfAbsent(Circle.Unit.KM, Query.GeoFilter.KILOMETERS);
        map.putIfAbsent(Circle.Unit.MI, Query.GeoFilter.MILES);
        map.putIfAbsent(Circle.Unit.FT, Query.GeoFilter.FEET);
    }

    public static String getUnitString(Circle.Unit unit) {
        return map.get(unit);
    }
}
