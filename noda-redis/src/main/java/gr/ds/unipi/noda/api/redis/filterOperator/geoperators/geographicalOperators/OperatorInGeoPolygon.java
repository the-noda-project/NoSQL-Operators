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
        return null;
    }

    @Override
    protected String[] getArgvArray() {

        String[] argvArray = new String[3 + getGeometry().getCoordinatesArray().length*2];
        argvArray[0] = getMatchingPattern();
        argvArray[1] = "longitude";
        argvArray[2] = "latitude";

        int j = 0;
        for (int i = 3; i < argvArray.length; i = i + 2) {
            argvArray[i] = String.valueOf(getGeometry().getCoordinatesArray()[i-3-j].getLongitude());
            argvArray[i+1] = String.valueOf(getGeometry().getCoordinatesArray()[i-3-j].getLatitude());
            j++;
        }
        return argvArray;
    }

}
