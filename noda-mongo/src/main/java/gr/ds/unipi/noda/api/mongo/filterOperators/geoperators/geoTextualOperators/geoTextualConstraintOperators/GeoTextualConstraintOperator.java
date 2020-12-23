package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import java.util.ArrayList;
import java.util.List;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.SmallHilbertCurve;
import org.davidmoten.hilbert.Ranges;
import  gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.*;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<StringBuilder,U> {

    protected GeoTextualConstraintOperator(GeographicalOperator<StringBuilder, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {

        super(geographicalOperator, conditionalTextualOperator);
    }
        

    @Override
    public StringBuilder getOperatorExpression(){
    	
        StringBuilder sb = new StringBuilder();
        String [] keywords=conditionalTextualOperator.getKeywords();
        sb.append("{ $and: [");
        sb.append(MongoDBGeographicalOperatorFactory.getGeometryExpression(getGeographicalOperator().getFieldName(), getGeographicalOperator().getGeometry()));
        sb.append(", ");
        sb.append(MongoDBGeoTextualOperatorFactory.getExpressionOfSpatioTextualHilbertIndexes(getGeographicalOperator().getGeometry().getCoordinatesArray(),keywords));
        sb.append(" ] }");
        return sb;

    
    }
}
   	
	

  	
    	
    	
    	
 