package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;

class OperatorGeoNearestNeighbors extends GeoSpatialOperator<Point> {

    private final int neighbors;

    private OperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorGeoNearestNeighbors newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return new OperatorGeoNearestNeighbors(fieldName, point, neighbors);
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
        sb.append("{ $geoNear: { near: {type: \"Point\", coordinates: [" + getGeometry().getPoint().getLongitude() + ", " + getGeometry().getPoint().getLatitude() + "]}," +
                //"key: "+ ((!getFieldName().contains(".")) ? getFieldName() : "\"" + getFieldName() + "\"") +" ," +
                "key: " + "\"" + getFieldName() + "\"" + " ," +

                "maxDistance: " + 5 + "," + "num: " + neighbors + " ," + "distanceField: \"distance\" ," + "spherical: true" + "} }");

        return sb;

    }

}
