package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators.OperatorInGeoCircle;

final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName,circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

    @Override
    protected String getEvalExpression() {
        return "local r =0.017453292519943295769236907684886;\n" +
                "  local function haversine(x1, y1, x2, y2)\n" +
                "  x1= x1*r; x2= x2*r; y1= y1*r; y2= y2*r; local u = math.sin((y2-y1)/2); local v = math.sin((x2-x1)/2);\n" +
                "  local a = math.pow(u,2) + math.cos(y1) * math.cos(y2) * math.pow(v,2); local c = 2 * math.asin(math.sqrt(a));\n" +
                "  return 6372797.560856 * c ;\n" +
                "end\n" +
                "\n" +
                "local temp = {}\n" +
                "\n" +
                "local patternMatch = ARGV[1]\n" +
                "local longitudeField = ARGV[2]\n" +
                "local latitudeField = ARGV[3]\n" +
                "local centerLongitude = tonumber(ARGV[4])\n" +
                "local centerLatitude = tonumber(ARGV[5])\n" +
                "local radius = tonumber(ARGV[6])\n" +
                "local timestampField = ARGV[7]\n" +
                "local minDate = tonumber(ARGV[8])\n" +
                "local maxDate = tonumber(ARGV[9]) \n" +
                "\n" +
                "local t = redis.call('SSCAN', KEYS[2], 0, 'match', patternMatch, 'count', 100000000)\n" +
                "\n" +
                "for i, key_name in ipairs(t[2]) do \n" +
                "\n" +
                "  local pruned = string.match(key_name, \"-([^-]+)$\")"+
                "  local s = redis.call(\"HMGET\", pruned, longitudeField, latitudeField, timestampField)\n" +
                "  local longitude = tonumber(s[1])\n" +
                "  local latitude = tonumber(s[2])\n" +
                "  local timestamp = tonumber(s[3])\n" +
                "\n" +
                "  if (timestamp >= minDate and timestamp <= maxDate and haversine(centerLongitude, centerLatitude, longitude, latitude) <= radius) then\n" +
                "    table.insert(temp, pruned)\n" +
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
        return new String[]{getMatchingPattern(), /*this.getGeographicalOperator().getFieldName()+":"+*/"longitude", /*this.getGeographicalOperator().getFieldName()+":"+*/"latitude", String.valueOf(getGeographicalOperator().getGeometry().getCircleCenter().getLongitude()), String.valueOf(getGeographicalOperator().getGeometry().getCircleCenter().getLatitude()), String.valueOf(getGeographicalOperator().getGeometry().getRadius()), String.valueOf(getTemporalFieldName()), String.valueOf(getTemporalType().getLowerBound().getTime()), String.valueOf(getTemporalType().getUpperBound().getTime())};
    }

}
