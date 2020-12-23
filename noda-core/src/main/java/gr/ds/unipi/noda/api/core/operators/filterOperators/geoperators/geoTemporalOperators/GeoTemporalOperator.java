package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class GeoTemporalOperator<T, U extends Geometry, S extends Temporal> implements FilterOperator<T> {

    private final GeographicalOperator<T, U> geographicalOperator;
    private final String temporalFieldName;
    private final S temporalType;

    protected GeoTemporalOperator(GeographicalOperator<T, U> geographicalOperator, String temporalFieldName, S temporalType) {
        this.geographicalOperator = geographicalOperator;
        this.temporalFieldName = temporalFieldName;
        this.temporalType = temporalType;
    }

    public static BaseGeoTemporalOperatorFactory geoTemporalOperator;

    protected String getTemporalFieldName() {
        return temporalFieldName;
    }

    protected S getTemporalType() {
        return temporalType;
    }

    protected GeographicalOperator<T, U> getGeographicalOperator() {
        return geographicalOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoTemporalOperator<?, ?, ?> that = (GeoTemporalOperator<?, ?, ?>) o;

        if (!geographicalOperator.equals(that.geographicalOperator)) return false;
        if (!temporalFieldName.equals(that.temporalFieldName)) return false;
        return temporalType.equals(that.temporalType);
    }

    @Override
    public int hashCode() {
        int result = geographicalOperator.hashCode();
        result = 31 * result + temporalFieldName.hashCode();
        result = 31 * result + temporalType.hashCode();
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
