package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

abstract class GeoTextualOperator<U extends Geometry, S extends TextualOperator> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator<Object, U, S> {

    protected GeoTextualOperator(String fieldName, U geometry, S textualOperator) {
        super(fieldName, geometry, textualOperator);
    }
}
