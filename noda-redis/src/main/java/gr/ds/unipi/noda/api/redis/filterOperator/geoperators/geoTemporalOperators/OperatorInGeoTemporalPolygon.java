package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators.OperatorInGeoPolygon;

final class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName,polygon), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
    }

    @Override
    protected String getEvalExpression() {
        return "local function insidePolygon(polygon, x, y)\n" +
                "    local oddNodes = false\n" +
                "    local j = #polygon\n" +
                "    for i = 1, #polygon do\n" +
                "        if (polygon[i][2] < y and polygon[j][2] >= y or polygon[j][2] < y and polygon[i][2] >= y) then\n" +
                "            if (polygon[i][1] + ( y - polygon[i][2] ) / (polygon[j][2] - polygon[i][2]) * (polygon[j][1] - polygon[i][1]) < x) then\n" +
                "                oddNodes = not oddNodes;\n" +
                "            end\n" +
                "        end\n" +
                "        j = i;\n" +
                "    end\n" +
                "    return oddNodes \n" +
                "end\n" +
                "\n" +
                "local temp = {}\n" +
                "local polygon = {}\n" +
                "\n" +
                "local patternMatch = ARGV[1]\n" +
                "local longitudeField = ARGV[2]\n" +
                "local latitudeField = ARGV[3]\n" +
                "local timestampField = ARGV[4]\n" +
                "local minDate = tonumber(ARGV[5])\n" +
                "local maxDate = tonumber(ARGV[6]) \n" +
                "local a, b = string.match(patternMatch, '(.*)%-(.*)') \n" +
                "a = tonumber(a)\n" +
                "b = tonumber(b)\n" +
                "\n" +
                "local i = 7\n" +
                "while i<=#ARGV do\n" +
                "    table.insert(polygon, {tonumber(ARGV[i]), tonumber(ARGV[i+1])})\n" +
                "    i = i + 2\n" +
                "end\n" +
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
                "  if (timestamp >= minDate and timestamp <= maxDate and insidePolygon(polygon, longitude, latitude)) then\n" +
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

        String[] argvArray = new String[6 + getGeographicalOperator().getGeometry().getCoordinatesArray().length*2];
        argvArray[0] = range;
        argvArray[1] = /*this.getGeographicalOperator().getFieldName()+":"+*/"longitude";
        argvArray[2] = /*this.getGeographicalOperator().getFieldName()+":"+*/"latitude";
        argvArray[3] = String.valueOf(getTemporalFieldName());
        argvArray[4] = String.valueOf(getTemporalType().getLowerBound().getTime());
        argvArray[5] = String.valueOf(getTemporalType().getUpperBound().getTime());

        int j = 0;
        for (int i = 6; i < argvArray.length; i = i + 2) {
            argvArray[i] = String.valueOf(getGeographicalOperator().getGeometry().getCoordinatesArray()[i-6-j].getLongitude());
            argvArray[i+1] = String.valueOf(getGeographicalOperator().getGeometry().getCoordinatesArray()[i-6-j].getLatitude());
            j++;
        }
        return argvArray;
    }

}
