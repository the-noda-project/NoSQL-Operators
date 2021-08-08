package gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
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
                "local a, b = string.match(patternMatch, '(.*)%-(.*)') \n" +
                "a = tonumber(a)\n" +
                "b = tonumber(b)\n" +
                "\n" +
                "local t = redis.call('ZRANGEBYSCORE', KEYS[2], a, b)\n" +
                "\n" +
                "for i, key_name in ipairs(t) do \n" +
                "\n" +
                "  local s = redis.call('HMGET', key_name, longitudeField, latitudeField)\n" +
                "  local longitude = tonumber(s[1])\n" +
                "  local latitude = tonumber(s[2])\n" +
                "\n" +
                "  if (haversine(centerLongitude, centerLatitude, longitude, latitude) <= radius) then\n" +
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

//        @Override
//    protected String getEvalExpression() {
//        return "local r =0.017453292519943295769236907684886127;\n" +
//                "  local function haversine(x1, y1, x2, y2)\n" +
//                "  x1= x1*r; x2= x2*r; y1= y1*r; y2= y2*r; local dy = y2-y1; local dx = x2-x1;\n" +
//                "  local a = math.pow(math.sin(dx/2),2) + math.cos(x1) * math.cos(x2) * math.pow(math.sin(dy/2),2); local c = 2 * math.asin(math.sqrt(a));\n" +
//                "  return 6372.8 * c * 1000;\n" +
//
//
//                "end\n" +
//                "\n" +
//                "local temp = {}\n" +
//                "\n" +
//                "local patternMatch = ARGV[1]\n" +
//                "local longitudeField = ARGV[2]\n" +
//                "local latitudeField = ARGV[3]\n" +
//                "local centerLongitude = tonumber(ARGV[4])\n" +
//                "local centerLatitude = tonumber(ARGV[5])\n" +
//                "local radius = tonumber(ARGV[6])\n" +
//                "\n" +
//                "local t = redis.call('GEORADIUS', KEYS[2], centerLongitude, centerLatitude, radius, 'm', 'count', 100000000)\n" +
//                "\n" +
//                "for i, key_name in ipairs(t) do \n" +
//                "  table.insert(temp, key_name)\n" +
//                "  if #temp >= 1000 then\n" +
//                "    redis.call('SADD', KEYS[1], unpack(temp))\n" +
//                "    temp = {}\n" +
//                "  end\n" +
//                "end \n" +
//                "if #temp > 0 then\n" +
//                "  redis.call('SADD', KEYS[1], unpack(temp))\n" +
//                "end\n" +
//                "redis.call('EXPIRE' , KEYS[1], 100)\n" +
//                "return 1";
//    }

    @Override
    protected String[] getArgvArray(String range) {
        return new String[]{range, AppConfig.redis().getString("spatialOp.longitudeField"), AppConfig.redis().getString("spatialOp.latitudeField"), String.valueOf(getGeometry().getCircleCenter().getLongitude()), String.valueOf(getGeometry().getCircleCenter().getLatitude()), String.valueOf(getGeometry().getRadius())};
    }

}