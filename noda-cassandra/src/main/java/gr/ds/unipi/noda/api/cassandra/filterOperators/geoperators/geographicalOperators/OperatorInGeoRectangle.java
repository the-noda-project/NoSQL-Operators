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
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder("INRECT(");
        operation.append(getFieldName()).append(",(");
        operation.append(getGeometry().getLowerBound().getLatitude());
        operation.append(",").append(getGeometry().getLowerBound().getLongitude()).append("),(");
        operation.append(getGeometry().getUpperBound().getLatitude()).append(",");
        operation.append(getGeometry().getUpperBound().getLongitude()).append(")");
        operation.append(")");
        return operation;
    }
}
