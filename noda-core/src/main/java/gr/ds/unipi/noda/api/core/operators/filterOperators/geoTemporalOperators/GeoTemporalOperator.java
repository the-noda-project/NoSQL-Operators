package gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators.geoTemporalGeometry.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

public abstract class GeoTemporalOperator<T, U extends Geometry, S extends Temporal> extends GeographicalOperator<T,U> {

    private final String temporalFieldName;
    private final S temporalType;

    protected GeoTemporalOperator(String fieldName, U geometry, String temporalFieldName, S temporalType) {
        super(fieldName,geometry);
        this.temporalFieldName = temporalFieldName;
        this.temporalType = temporalType;
    }
}
