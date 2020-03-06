package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

import java.util.Date;

public abstract class GeographicalTemporalOperator extends GeographicalOperator {

    private final String temporalFieldName;
    private final Date[] dateArray;

    protected GeographicalTemporalOperator(String temporalFieldName, Date[] dateArray, String fieldName, Coordinates... coordinatesArray) {
        super(fieldName, coordinatesArray);
        this.temporalFieldName = temporalFieldName;
        this.dateArray = dateArray;
    }

    protected Date[] getDateArray() {
        return dateArray;
    }

    protected String getTemporalFieldName() {
        return temporalFieldName;
    }
}
