package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public class OperatorInGeoTextualRectangle extends GeoTextualConstraintOperator<Rectangle> {

    protected OperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualRectangle newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return new OperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }

    @Override
    public String[] getOperatorExpression() {
        String[] operation = new String[2];

        //Coordinates bound--WHERE clause
        operation[0] = (String) getGeographicalOperator().getOperatorExpression();

        //Textual constrain--SELECT clause
        operation[1] = getConditionalTextualOperator().getOperatorExpression().toString();

        return operation;
    }
}
