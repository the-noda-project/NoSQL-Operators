package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class RoadNetworkOperator<T> implements FilterOperator<T> {
    private final String objectIdField;
    private final String segmentField;

    protected RoadNetworkOperator(String objectIdField, String segmentField) {
        this.objectIdField = objectIdField;
        this.segmentField = segmentField;
    }

    public static BaseRoadNetworkOperatorFactory roadNetworkOperator;

    protected String getObjectIdField(){
        return objectIdField;
    }

    protected String getSegmentField(){
        return segmentField;
    }
}
