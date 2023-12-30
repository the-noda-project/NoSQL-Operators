package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;

public class OperatorInGeoTextualRectangle extends GeoTextualConstraintOperator<Rectangle> {

    protected OperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), conditionalTextualOperator);
    }

    // @Override
    // public Filter getOperatorExpression() {
    //     return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getFieldName(),this.getGeographicalOperator().getGeometry().getCoordinatesArray(), this.getConditionalTextualOperator());
    //return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getOperatorExpression(), this.getConditionalTextualOperator());

    //  }

    public static OperatorInGeoTextualRectangle newOperatorInGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return new OperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }
}
