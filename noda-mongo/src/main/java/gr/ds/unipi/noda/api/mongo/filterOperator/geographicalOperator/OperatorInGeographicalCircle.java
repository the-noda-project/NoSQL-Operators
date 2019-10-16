package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnSinglePoint {

    private final double radius;//radius is in meters

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        super(fieldName, point);
        this.radius = radius;
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        return new OperatorInGeographicalCircle(fieldName, point, radius);
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
        sb.append(getLongitude());
        sb.append(", ");
        sb.append(getLatitude());
        sb.append("], ");
        sb.append(radius / 6378137);
        sb.append(" ] } } }");

        return sb;

    }

}