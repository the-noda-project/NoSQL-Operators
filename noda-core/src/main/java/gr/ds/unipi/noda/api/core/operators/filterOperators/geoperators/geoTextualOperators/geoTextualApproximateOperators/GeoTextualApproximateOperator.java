package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class GeoTextualApproximateOperator<T,U extends Geometry> extends GeoTextualOperator<T,U> {

    private final String fieldName;
    private final String[] keywords;

    protected GeoTextualApproximateOperator(GeographicalOperator<T, U> geographicalOperator, String fieldName, String[] keywords) {
        super(geographicalOperator);
        this.fieldName = fieldName;
        this.keywords = keywords;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String[] getKeywords() {
        return keywords;
    }
}
