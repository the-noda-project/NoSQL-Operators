package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

class OperatorInGeographicalCircle extends GeoSpatialOperator<Circle> {

    private OperatorInGeographicalCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeographicalCircle(fieldName, circle);
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