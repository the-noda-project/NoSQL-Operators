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
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder("INPOLY(");
        operation.append(getFieldName()).append(",[");
        ArrayList<String> points = new ArrayList<>();
        for(Coordinates coordinate:getGeometry().getCoordinatesArray()){
           points.add("("+coordinate.getLatitude()+","+coordinate.getLongitude()+")");
        }
        operation.append(String.join(",",points)).append("])");
        return operation;
    }

}
