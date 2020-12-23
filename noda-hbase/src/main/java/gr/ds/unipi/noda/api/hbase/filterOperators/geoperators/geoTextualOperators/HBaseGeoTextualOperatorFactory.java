package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.*;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.SmallHilbertCurve;
import org.davidmoten.hilbert.Ranges;
import  gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;

public final class HBaseGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator  inGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualRectangle.newOperatorInGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);

    }

    @Override
    public GeoTextualConstraintOperator  inGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return null;
    }

    @Override
    public GeoTextualConstraintOperator  inGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualRectangle(String fieldName, Rectangle rectangle, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualCircle(String fieldName, Circle circle, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }

    @Override
    public GeoTextualApproximateOperator topRankInGeoTextualPolygon(String fieldName, Polygon polygon, String keywordFieldName, Collection<String> keywords, int topK) {
        return null;
    }
    
    
    public static List<String> getExpressionOfSpatioTextualHilbertIndexes(Coordinates[] coordinates, String [] keywords){
    	
        int bits = 5;
        int dimensions = 2;
        SmallHilbertCurve h = HilbertCurve.small().bits(bits).dimensions(dimensions);
        long max = 1L << bits;
        double maxLon= 180d;
        double minLon= -180d;
        double maxLat= 90d;
        double minLat= -90d;
        double lon1= coordinates[0].getLongitude();
        double lon2= coordinates[2].getLongitude();
        double lat1= coordinates[0].getLatitude();
        double lat2= coordinates[2].getLatitude();
        
        Ranges rangesList = h.query(HilbertUtil.scaleGeoPoint(lon1, minLon,maxLon,lat1, minLat,maxLat, max),
       		 HilbertUtil.scaleGeoPoint(lon2, minLon,maxLon,lat2, minLat,maxLat, max));
       
        List<String> hilbertresults = new ArrayList<String>();
        
        for(int word =0;word<keywords.length;word++){
       	  String keyword=keywords[word];
   	        rangesList.stream().forEach(i->{
   	                for(long k=i.low(); k<= i.high(); k++){
   	                	hilbertresults.add(k+keyword);                  
   	                }          
   	        });
         }   
        
        return hilbertresults;
    	
    }
}
