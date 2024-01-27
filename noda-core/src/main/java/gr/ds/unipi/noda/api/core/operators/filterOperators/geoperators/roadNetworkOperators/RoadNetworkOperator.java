package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class RoadNetworkOperator<T> implements FilterOperator<T> {

    protected RoadNetworkOperator() {
    }

    public static BaseRoadNetworkOperatorFactory roadNetworkOperator;

}
