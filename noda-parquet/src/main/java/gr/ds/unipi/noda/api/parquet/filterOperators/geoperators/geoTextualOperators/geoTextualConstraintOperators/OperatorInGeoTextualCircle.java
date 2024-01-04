package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

public class OperatorInGeoTextualCircle extends GeoTextualConstraintOperator<Circle> {
    protected OperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName,circle), conditionalTextualOperator);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoTextualCircle newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator){
        return new OperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }
}
