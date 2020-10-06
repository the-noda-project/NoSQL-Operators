package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;

public final class OperatorInGeoPolygon extends GeographicalOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
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
                "\n" +
                "local i = 4\n" +
                "while i<=#ARGV do\n" +
                "    table.insert(polygon, {tonumber(ARGV[i]), tonumber(ARGV[i+1])})\n" +
                "    i = i + 2\n" +
                "end\n" +
                "\n" +
                "local t = redis.call('SSCAN', KEYS[2], 0, 'match', patternMatch)\n" +
                "\n" +
                "for i, key_name in ipairs(t[2]) do \n" +
                "\n" +
                "  local s = redis.call(\"HMGET\", key_name, longitudeField, latitudeField)\n" +
                "  local longitude = tonumber(s[1])\n" +
                "  local latitude = tonumber(s[2])\n" +
                "\n" +
                "  if (insidePolygon(polygon, longitude, latitude)) then\n" +
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

        String[] argvArray = new String[3 + getGeometry().getCoordinatesArray().length*2];
        argvArray[0] = getMatchingPattern();
        argvArray[1] = getFieldName()+":"+"longitude";
        argvArray[2] = getFieldName()+":"+"latitude";

        int j = 0;
        for (int i = 3; i < argvArray.length; i = i + 2) {
            argvArray[i] = String.valueOf(getGeometry().getCoordinatesArray()[i-3-j].getLongitude());
            argvArray[i+1] = String.valueOf(getGeometry().getCoordinatesArray()[i-3-j].getLatitude());
            j++;
        }
        return argvArray;
    }

}
