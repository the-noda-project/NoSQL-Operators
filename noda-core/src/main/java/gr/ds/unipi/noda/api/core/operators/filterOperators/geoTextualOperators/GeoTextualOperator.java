package gr.ds.unipi.noda.api.core.operators.filterOperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public abstract class GeoTextualOperator<T, U extends Geometry, S extends TextualOperator> extends GeographicalOperator<T, U> {

    private final S textualOperator;

    protected GeoTextualOperator(String fieldName, U geometry, S textualOperator) {
        super(fieldName, geometry);
        this.textualOperator = textualOperator;
    }
}
