package gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.*;

public final class RedisGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon);
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircle(String fieldName, Circle circle) {
        return OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    public static String getGeoHashPart(Geometry geometry){
        Rectangle mbr = geometry.getMbr();
        System.out.println("( "+mbr.getLowerBound().getLongitude()+ ", " +mbr.getLowerBound().getLatitude()+")"+", ("+mbr.getUpperBound().getLongitude()+ ", " +mbr.getUpperBound().getLatitude() +")");
        int length = 5;
        String geoHash = (String) GeoHash.coverBoundingBoxMaxHashes(mbr.getUpperBound().getLatitude(), mbr.getLowerBound().getLongitude(), mbr.getLowerBound().getLatitude(),mbr.getUpperBound().getLongitude(),1).getHashes().toArray()[0];

        if(geoHash.length()>length){
            geoHash = geoHash.substring(0,length);
        }

        return String.format("%-"+length+"s",geoHash).replace(' ','?');
    }
}
