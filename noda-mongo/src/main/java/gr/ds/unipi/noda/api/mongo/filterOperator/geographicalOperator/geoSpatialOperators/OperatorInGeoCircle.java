package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

public class OperatorInGeoCircle extends GeoSpatialOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

//    @Override
//    int getNumberOfResultsForJsonStringBuilder() {
//        return Integer.MAX_VALUE;
//    }

//    @Override
//    double getRadiusForJsonStringBuilder() {
//        return radius;
//    }

    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $geoWithin: { $centerSphere: [");

        sb.append(" [");
        sb.append(getGeometry().getCircleCenter().getLongitude());
        sb.append(", ");
        sb.append(getGeometry().getCircleCenter().getLatitude());
        sb.append("], ");
        sb.append(getGeometry().getRadius() / 6378137);
        sb.append(" ] } } }");

        return sb;

    }

}