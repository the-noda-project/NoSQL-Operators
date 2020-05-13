package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<StringBuilder, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }


}
