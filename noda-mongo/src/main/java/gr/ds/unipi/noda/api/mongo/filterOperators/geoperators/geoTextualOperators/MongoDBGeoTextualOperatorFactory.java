package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.*;
import java.util.Collection;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.*;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

public final class MongoDBGeoTextualOperatorFactory extends BaseGeoTextualOperatorFactory {
    @Override
    public GeoTextualConstraintOperator inGeoTextualRectangle(String fieldName, Rectangle rectangle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualRectangle.inGeoTextualRectangle(fieldName, rectangle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator inGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualCircle.inGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }

    @Override
    public GeoTextualConstraintOperator inGeoTextualPolygon(String fieldName, Polygon polygon, ConditionalTextualOperator conditionalTextualOperator) {
        return OperatorInGeoTextualPolygon.inGeoTextualPolygon(fieldName, polygon, conditionalTextualOperator);
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
    
    public static StringBuilder getExpressionOfSpatioTextualHilbertIndexes(Coordinates[] coordinates, String [] keywords){

        final int bits = 5;
        final long max = 1L << bits;
        
        SmallHilbertCurve h = HilbertCurve.small().bits(bits).dimensions(2);
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
        
        
        StringBuilder sbfinal = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbkewords = new StringBuilder();

        for(int word =0;word<keywords.length;word++){
       	  String keyword=keywords[word];
       	  sbkewords.append("\""+keyword+"\""+",");
            rangesList.stream().forEach(i->{
           
                    for(long k=i.low(); k<= i.high(); k++){
                        sb.append("\""+k+keyword+"\""+",");
                        
                    }
                
            });
        }   
        sb.deleteCharAt(sb.length()-1);
        sbfinal.append("{hilbertindex:{$in:["+sb.toString()+"]}}");
       return sbfinal;
    }

    
}
