package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public class OperatorInGeoTextualCircle extends GeoTextualConstraintOperator<Circle> {
    protected OperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualCircle newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return new OperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
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
