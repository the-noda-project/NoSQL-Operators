package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import com.github.davidmoten.guavamini.Preconditions;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<StringBuilder, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<StringBuilder,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }

//    public static long[] scalePoint(double lat, double lon, long time, long minTime, long maxTime, long max) {
//        long x = scale((lat + 90.0) / 180, max);
//        long y = scale((lon + 180.0) / 360, max);
//        long z = scale(( time - minTime) / (maxTime - minTime), max);
//        return new long[] { x, y, z };
//    }
//
//    private static long scale(double d, long max) {
//
//        Preconditions.checkArgument(Double.compare(d,0) != -1 &&  Double.compare(d,1) != 1);
//        if ( Double.compare(d,1) == 0 ) {
//            return max;
//        } else {
//            return Math.round(Math.floor(d * (max + 1)));
//        }
//    }



}



