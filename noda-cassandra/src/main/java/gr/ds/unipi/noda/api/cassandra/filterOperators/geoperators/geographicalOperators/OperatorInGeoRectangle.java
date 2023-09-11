package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public String getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName()).append("_longitude").append(">=").append(getGeometry().getLowerBound().getLongitude());
        operation.append(" AND ");
        operation.append(getFieldName()).append("_latitude").append(">=").append(getGeometry().getLowerBound().getLatitude());
        operation.append(" AND ");
        operation.append(getFieldName()).append("_longitude").append("<=").append(getGeometry().getUpperBound().getLongitude());
        operation.append(" AND ");
        operation.append(getFieldName()).append("_latitude").append("<=").append(getGeometry().getUpperBound().getLatitude());
        return operation.toString();
    }
}
