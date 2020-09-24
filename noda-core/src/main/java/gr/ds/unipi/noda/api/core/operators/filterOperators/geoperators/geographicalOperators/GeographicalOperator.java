package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class GeographicalOperator<T, U extends Geometry> implements FilterOperator<T> {

    private final String fieldName;
    private final U geometry;

    protected GeographicalOperator(String fieldName, U geometry) {
        this.fieldName = fieldName;
        this.geometry = geometry;
    }

    public String getFieldName() {
        return fieldName;
    }

    public U getGeometry() {
        return geometry;
    }

    public static BaseGeographicalOperatorFactory geoSpatialOperator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeographicalOperator<?, ?> that = (GeographicalOperator<?, ?>) o;

        if (!fieldName.equals(that.fieldName)) return false;
        return geometry.equals(that.geometry);
    }

    @Override
    public int hashCode() {
        int result = fieldName.hashCode();
        result = 31 * result + geometry.hashCode();
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
