package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;

public class OperatorInGeoTextualRectangle extends GeoTextualConstraintOperator<Rectangle> {
    protected OperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator<FilterStrategy> conditionalTextualOperator) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName,rectangle), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualRectangle newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator<FilterStrategy> conditionalTextualOperator){
        return new OperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        return null;
    }
}
