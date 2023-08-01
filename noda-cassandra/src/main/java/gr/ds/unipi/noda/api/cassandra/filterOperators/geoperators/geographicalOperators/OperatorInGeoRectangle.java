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
    public String[] getOperatorExpression(){
        String[] operation = new String[2];

        StringBuilder selectClause = new StringBuilder("INRECT(");
        selectClause.append(getFieldName()).append(",(");
        selectClause.append(getGeometry().getLowerBound().getLatitude());
        selectClause.append(",").append(getGeometry().getLowerBound().getLongitude()).append("),(");
        selectClause.append(getGeometry().getUpperBound().getLatitude()).append(",");
        selectClause.append(getGeometry().getUpperBound().getLongitude()).append(")");
        operation[0] = selectClause.append(")").toString();


        StringBuilder whereClause = new StringBuilder(getFieldName());
        whereClause.append(">=[");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLatitude());
        whereClause.append(",");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLongitude());
        whereClause.append("] AND ");
        whereClause.append(getFieldName());
        whereClause.append(" <= [");
        whereClause.append(getGeometry().getMbr().getMbr().getUpperBound().getLatitude());
        whereClause.append(",");
        whereClause.append(getGeometry().getMbr().getUpperBound().getLongitude());
        whereClause.append("]");
        operation[1] = whereClause.toString();

        return operation;
    }
}
