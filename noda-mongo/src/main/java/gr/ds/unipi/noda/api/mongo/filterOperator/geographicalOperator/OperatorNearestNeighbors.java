package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

class OperatorNearestNeighbors extends GeographicalOperatorBasedOnSinglePoint {

    private final int neighbors;

    private OperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return new OperatorNearestNeighbors(fieldName, point, neighbors);
    }

//    @Override
//    int getNumberOfResultsForJsonStringBuilder() {
//        return neighbors;
//    }
//
//    @Override
//    double getRadiusForJsonStringBuilder() {
//        return 5;
//    }

    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();
        sb.append("{ $geoNear: { near: {type: \"Point\", coordinates: [" + getLongitude() + ", " + getLatitude() + "]}," +
                //"key: "+ ((!getFieldName().contains(".")) ? getFieldName() : "\"" + getFieldName() + "\"") +" ," +
                "key: " + "\"" + getFieldName() + "\"" + " ," +

                "maxDistance: " + 5 + "," + "num: " + neighbors + " ," + "distanceField: \"distance\" ," + "spherical: true" + "} }");

        return sb;

    }

}
