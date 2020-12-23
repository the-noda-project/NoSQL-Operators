package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.OperatorInGeoPolygon;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

public class OperatorInGeoTextualPolygon extends GeoTextualConstraintOperator<Polygon> {

    protected OperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualPolygon newOperatorInGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator){
        return new OperatorInGeoTextualPolygon(fieldName, polygon, conditionalTextualOperator);   
    }
    
   // @Override
   // public Filter getOperatorExpression() {
    //    return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getFieldName(),this.getGeographicalOperator().getGeometry().getCoordinatesArray(), this.getConditionalTextualOperator());

        //return GeoTextualConstraintOperator.formGeometryAndTextualExpression(this.getGeographicalOperator().getOperatorExpression(), this.getConditionalTextualOperator());
    //}
}