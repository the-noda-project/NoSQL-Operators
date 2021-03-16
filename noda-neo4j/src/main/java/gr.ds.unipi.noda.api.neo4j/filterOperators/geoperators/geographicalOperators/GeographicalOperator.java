package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.guavamini.Preconditions;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<StringBuilder, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

//    public static long[] scalePoint(double lat, double lon, long max) {
//        long x = scale((lat + 90.0) / 180, max);
//        long y = scale((lon + 180.0) / 360, max);
//        return new long[] { x, y };
//    }
//
//    public static long scale(double d, long max) {
//
//        Preconditions.checkArgument(Double.compare(d,0) != -1 &&  Double.compare(d,1) != 1);
//        if ( Double.compare(d,1) == 0 ) {
//            return max;
//        } else {
//            return Math.round(Math.floor(d * (max + 1)));
//        }
//    }

}
