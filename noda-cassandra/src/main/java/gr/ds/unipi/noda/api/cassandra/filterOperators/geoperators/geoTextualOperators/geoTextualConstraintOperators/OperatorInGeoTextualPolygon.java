package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public class OperatorInGeoTextualPolygon extends GeoTextualConstraintOperator<Polygon> {
    protected OperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualPolygon newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        return new OperatorInGeoTextualPolygon(fieldName, polygon, conditionalTextualOperator);
    }

    @Override
    public String[] getOperatorExpression() {
        String[] operation = new String[3];
        String[] geoOperatorExpression = (String[]) getGeographicalOperator().getOperatorExpression();

        //UDF for the select clause--SELECT clause
        operation[0] = geoOperatorExpression[0];

        //GeoHashes--WHERE clause
        operation[1] = geoOperatorExpression[1];

        //Textual constrain--SELECT clause
        operation[2] = getConditionalTextualOperator().getOperatorExpression().toString();

        return operation;
    }
}
