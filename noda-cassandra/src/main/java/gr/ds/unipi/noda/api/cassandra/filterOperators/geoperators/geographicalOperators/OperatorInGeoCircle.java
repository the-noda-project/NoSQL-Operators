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
    public String[] getOperatorExpression () {

        String[] operation = new String[2];

        StringBuilder selectClause = new StringBuilder("INCIRCLE(");
        selectClause.append(getFieldName()).append(",").append(getGeometry().getCircleCenter().getLatitude()).append(",").append(getGeometry().getCircleCenter().getLongitude());
        selectClause.append(",").append(getGeometry().getRadius());
        operation[0] = selectClause.append(")").toString();

        StringBuilder whereClause = new StringBuilder(getFieldName());
        whereClause.append(">=[");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLatitude()-getGeometry().getRadius());
        whereClause.append(",");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLongitude()-getGeometry().getRadius());
        whereClause.append("] AND ").append(getFieldName()).append(" <= [");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLatitude()+getGeometry().getRadius());
        whereClause.append(" , ");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLongitude()+getGeometry().getRadius());
        whereClause.append("]");
        operation[1] = whereClause.toString();

        return operation;
    }

}