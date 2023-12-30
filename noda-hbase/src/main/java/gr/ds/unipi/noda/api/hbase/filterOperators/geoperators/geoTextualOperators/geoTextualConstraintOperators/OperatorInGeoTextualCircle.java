package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

public class OperatorInGeoTextualCircle extends GeoTextualConstraintOperator<Circle> {
    protected OperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), conditionalTextualOperator);
    }

    // @Override
    //  public Filter getOperatorExpression() {
    //     return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getFieldName(),this.getGeographicalOperator().getGeometry().getCoordinatesArray(), this.getConditionalTextualOperator());

    //return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getOperatorExpression(), this.getConditionalTextualOperator());
    // }

    public static OperatorInGeoTextualCircle newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return new OperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }
}
