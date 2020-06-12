package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class GeoTextualConstraintOperator<T,U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<T,U> {

    protected GeoTextualConstraintOperator(GeographicalOperator<T,U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {
        super(geographicalOperator, conditionalTextualOperator);
    }
        
    static StringBuilder formGeometryAndTextualExpression(StringBuilder geometryExpr, ConditionalTextualOperator conditionalTextualOperator) {
        StringBuilder sb = new StringBuilder();

        sb.append("{ $");
        sb.append("and");
        sb.append(": [ ");

        sb.append(geometryExpr);
        sb.append(", ");

        sb.append("{ ");
        sb.append(conditionalTextualOperator.getFieldName());
        sb.append(": { ");
        sb.append("$in: ");
        sb.append(conditionalTextualOperator.getKeywords());
        
        sb.append("} }");

        sb.append(" ] }");
        return sb;
    }
    
}