package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import java.util.ArrayList;

public final class OperatorInGeoPolygon extends GeographicalOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }

    @Override
    public String[] getOperatorExpression(){
        String[] operation = new String[2];

        StringBuilder selectClause = new StringBuilder("INPOLY(");
        selectClause.append(getFieldName()).append(",[");
        ArrayList<String> points = new ArrayList<>();
        for(Coordinates coordinate:getGeometry().getCoordinatesArray()){
           points.add("("+coordinate.getLatitude()+","+coordinate.getLongitude()+")");
        }
        selectClause.append(String.join(",",points)).append("])");
        operation[0] = selectClause.toString();



        StringBuilder whereClause = new StringBuilder(getFieldName());
        whereClause.append(">=[");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLatitude());
        whereClause.append(",");
        whereClause.append(getGeometry().getMbr().getLowerBound().getLongitude());
        whereClause.append("] AND "+getFieldName()+" <= [");
        whereClause.append(getGeometry().getMbr().getMbr().getUpperBound().getLatitude());
        whereClause.append(",");
        whereClause.append(getGeometry().getMbr().getUpperBound().getLongitude());
        whereClause.append("]");
        operation[1] = whereClause.toString();

        return operation;
    }

}
