package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface GeographicalOperator<T extends Number> extends FilterOperator {

    String getFieldName();


    default void checkLonLatRange(T  longitude, T latitude)
    {
        if((Double.compare(longitude.doubleValue(),180)  == 1) || (Double.compare(longitude.doubleValue(),-180)  == -1)
        || (Double.compare(latitude.doubleValue(),90)  == 1) || (Double.compare(latitude.doubleValue(),-90)  == -1)){

            try {
                throw new Exception("Longitude values are incorrect");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
