package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.MongoDBGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<StringBuilder, U> {

    protected GeoTextualConstraintOperator(GeographicalOperator<StringBuilder, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {

        super(geographicalOperator, conditionalTextualOperator);
    }


    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();
        String[] keywords = getConditionalTextualOperator().getKeywords();
        sb.append("{ $and: [");
        sb.append(MongoDBGeographicalOperatorFactory.getGeometryExpression(getGeographicalOperator().getFieldName(), getGeographicalOperator().getGeometry()));
        sb.append(", ");
        sb.append(MongoDBGeoTextualOperatorFactory.getExpressionOfSpatioTextualHilbertIndexes(getGeographicalOperator().getGeometry().getCoordinatesArray(), keywords));
        sb.append(" ] }");
        return sb;


    }
}
   	
	

  	
    	
    	
    	
 