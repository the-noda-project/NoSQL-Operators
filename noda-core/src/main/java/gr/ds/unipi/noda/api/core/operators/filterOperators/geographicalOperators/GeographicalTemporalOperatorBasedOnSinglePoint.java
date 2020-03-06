package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

import java.util.Date;

public abstract class GeographicalTemporalOperatorBasedOnSinglePoint extends GeographicalTemporalOperator {

    protected GeographicalTemporalOperatorBasedOnSinglePoint(String fieldName, Date[] dateArray, Coordinates... coordinatesArray) {
        super(fieldName, dateArray, coordinatesArray);
    }

    protected double getLongitude() {
        return getCoordinatesArray()[0].getLongitude();
    }

    protected double getLatitude() {
        return getCoordinatesArray()[0].getLatitude();
    }


}
