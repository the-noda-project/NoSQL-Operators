package gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Unit;
import io.redisearch.Query;

import java.util.EnumMap;
import java.util.Map;

public class RediSearchUnitMap {
    private static final Map<Unit, String> map = new EnumMap<>(Unit.class);

    static {
        map.putIfAbsent(Unit.M, Query.GeoFilter.METERS);
        map.putIfAbsent(Unit.KM, Query.GeoFilter.KILOMETERS);
        map.putIfAbsent(Unit.MI, Query.GeoFilter.MILES);
        map.putIfAbsent(Unit.FT, Query.GeoFilter.FEET);
    }

    public static String getUnitString(Unit unit) {
        return map.get(unit);
    }
}
