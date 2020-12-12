package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators.OperatorInGeoRectangle;

final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
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
                "local timestampField = ARGV[8]\n" +
                "local minDate = tonumber(ARGV[9])\n" +
                "local maxDate = tonumber(ARGV[10]) \n" +
                "local a, b = string.match(patternMatch, '(.*)%-(.*)') \n" +
                "a = tonumber(a)\n" +
                "b = tonumber(b)\n" +
                "\n" +
                "local t = redis.call('ZRANGEBYSCORE', KEYS[2], a, b)\n" +
                "\n" +
                "for i, key_name in ipairs(t) do \n" +
                "\n" +
                "  local s = redis.call('HMGET', key_name, longitudeField, latitudeField, timestampField)\n" +
                "  local longitude = tonumber(s[1])\n" +
                "  local latitude = tonumber(s[2])\n" +
                "  local timestamp = tonumber(s[3])\n" +
                "\n" +
                "  if (longitude >= minLon and longitude <= maxLon and latitude >= minLat and latitude <= maxLat and timestamp >= minDate and timestamp <= maxDate ) then\n" +
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
    protected String[] getArgvArray(String range) {
        return new String[]{range, /*this.getGeographicalOperator().getFieldName()+":"+*/"longitude", /*this.getGeographicalOperator().getFieldName()+":"+*/"latitude", String.valueOf(getGeographicalOperator().getGeometry().getLowerBound().getLongitude()), String.valueOf(getGeographicalOperator().getGeometry().getUpperBound().getLongitude()), String.valueOf(getGeographicalOperator().getGeometry().getLowerBound().getLatitude()), String.valueOf(getGeographicalOperator().getGeometry().getUpperBound().getLatitude()), String.valueOf(getTemporalFieldName()), String.valueOf(getTemporalType().getLowerBound().getTime()), String.valueOf(getTemporalType().getUpperBound().getTime())};
    }

}
