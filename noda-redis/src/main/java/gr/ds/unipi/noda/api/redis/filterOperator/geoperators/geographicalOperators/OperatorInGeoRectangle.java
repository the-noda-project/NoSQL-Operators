package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    @Override
    protected String getEvalExpression() {
        return "local temp = {}\n" +
                "\n" +
                "local patternMatch = ARGV[1]\n" +
                "local longitudeField = ARGV[2]\n" +
                "local latitudeField = ARGV[3]\n" +
                "local minLon = tonumber(ARGV[4])\n" +
                "local maxLon = tonumber(ARGV[5])\n" +
                "local minLat = tonumber(ARGV[6])\n" +
                "local maxLat = tonumber(ARGV[7])\n" +
                "\n" +
                "local t = redis.call('SSCAN', KEYS[2], 0, 'match', patternMatch)\n" +
                "\n" +
                "for i, key_name in ipairs(t[2]) do \n" +
                "\n" +
                "  local s = redis.call(\"HMGET\", key_name, longitudeField, latitudeField)\n" +
                "  local longitude = tonumber(s[1])\n" +
                "  local latitude = tonumber(s[2])\n" +
                "\n" +
                "  if (longitude >= minLon and longitude <= maxLon and latitude >= minLat and latitude <= maxLat) then\n" +
                "    table.insert(temp, key_name)\n" +
                "  end\n" +
                "\n" +
                "  if #temp >= 1000 then\n" +
                "    redis.call('SADD', KEYS[1], unpack(temp))\n" +
                "    temp = {}\n" +
                "  end\n" +
                "end \n" +
                "if #temp > 0 then\n" +
                "  redis.call('SADD', KEYS[1], unpack(temp))\n" +
                "end\n" +
                "redis.call('EXPIRE' , KEYS[1], 100)\n" +
                "return 1";
    }

    @Override
    protected String[] getArgvArray() {
        return new String[]{getMatchingPattern(), getFieldName()+":"+"longitude", getFieldName()+":"+"latitude", String.valueOf(getGeometry().getLowerBound().getLongitude()), String.valueOf(getGeometry().getUpperBound().getLongitude()), String.valueOf(getGeometry().getLowerBound().getLatitude()), String.valueOf(getGeometry().getUpperBound().getLatitude())};
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

}
