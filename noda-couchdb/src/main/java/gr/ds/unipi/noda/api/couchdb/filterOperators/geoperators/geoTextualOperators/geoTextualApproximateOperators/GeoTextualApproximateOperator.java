package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

public abstract class GeoTextualApproximateOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.GeoTextualApproximateOperator<FilterStrategy, U> {
    protected GeoTextualApproximateOperator(GeographicalOperator<FilterStrategy, U> geographicalOperator, String fieldName, String[] keywords) {
        super(geographicalOperator, fieldName, keywords);
    }
}
