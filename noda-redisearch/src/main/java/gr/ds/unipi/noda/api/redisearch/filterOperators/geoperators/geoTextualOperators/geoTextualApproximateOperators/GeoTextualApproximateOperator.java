package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class GeoTextualApproximateOperator<T,U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator<T,U> {

    protected GeoTextualApproximateOperator(GeographicalOperator<T, U> geographicalOperator, String fieldName, String[] keywords) {
        super(geographicalOperator, fieldName, keywords);
    }
}
