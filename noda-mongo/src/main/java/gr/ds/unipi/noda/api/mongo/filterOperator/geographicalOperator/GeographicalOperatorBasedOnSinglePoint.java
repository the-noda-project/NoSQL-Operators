package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

abstract class GeographicalOperatorBasedOnSinglePoint extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnSinglePoint<StringBuilder> {

    protected GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
        super(fieldName, point);
    }

}
