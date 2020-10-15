package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

import java.util.Arrays;

public abstract class GeoTextualApproximateOperator<T,U extends Geometry> extends GeoTextualOperator<T,U> {

    private final String fieldName;
    private final String[] keywords;

    protected GeoTextualApproximateOperator(GeographicalOperator<T, U> geographicalOperator, String fieldName, String[] keywords) {
        super(geographicalOperator);
        this.fieldName = fieldName;
        this.keywords = keywords;

        if(keywords.length == 0){
            try {
                throw new Exception("No keywords have been defined");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String getFieldName() {
        return fieldName;
    }

    public String[] getKeywords() {
        return keywords.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GeoTextualApproximateOperator<?, ?> that = (GeoTextualApproximateOperator<?, ?>) o;

        if (!fieldName.equals(that.fieldName)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fieldName.hashCode();
        result = 31 * result + Arrays.hashCode(keywords);
        return result;
    }
}
