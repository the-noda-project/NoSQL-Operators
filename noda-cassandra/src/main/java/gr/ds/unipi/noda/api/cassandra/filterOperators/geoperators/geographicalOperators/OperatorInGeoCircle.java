package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }


    @Override
    public StringBuilder getOperatorExpression () {
        StringBuilder operation = new StringBuilder("INCIRCLE(");
        operation.append(getFieldName()).append(",").append(getGeometry().getCircleCenter().getLatitude()).append(",").append(getGeometry().getCircleCenter().getLongitude());
        operation.append(",").append(getGeometry().getRadius());
        operation.append(")");
        return operation;
    }

}