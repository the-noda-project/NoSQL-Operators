package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.geographicalOperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

abstract class GeoTextualOperator<U extends Geometry, S extends TextualOperator> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTextualOperators.GeoTextualOperator<Object, U, S> {

    protected GeoTextualOperator(String fieldName, U geometry, S textualOperator) {
        super(fieldName, geometry, textualOperator);
    }
}
