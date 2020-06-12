package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;

public class OperatorInGeoTextualPolygon extends GeoTextualConstraintOperator<StringBuilder, Polygon> {
	
    protected OperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualPolygon newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator){
        return new OperatorInGeoTextualPolygon(fieldName, polygon, conditionalTextualOperator);   
    }
    
    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getOperatorExpression(), this.getConditionalTextualOperator());
    }
}