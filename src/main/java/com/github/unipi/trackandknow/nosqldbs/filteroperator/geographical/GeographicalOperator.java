package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface GeographicalOperator<T extends Number> extends FilterOperator {

    String getFieldName();


    default void checkLonLatRange(T lowerLongitude, T lowerLatitude, T upperLongitude, T upperLatitude)
    {
        if((Double.compare(lowerLongitude.doubleValue(),180)  == 1) || (Double.compare(lowerLongitude.doubleValue(),-180)  == -1)
        || (Double.compare(upperLongitude.doubleValue(),180)  == 1) || (Double.compare(upperLongitude.doubleValue(),-180)  == -1)){

            try {
                throw new Exception("Longitude values are incorrect");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if((Double.compare(lowerLatitude.doubleValue(),90)  == 1) || (Double.compare(lowerLatitude.doubleValue(),-90)  == -1)
                || (Double.compare(upperLatitude.doubleValue(),90)  == 1) || (Double.compare(upperLatitude.doubleValue(),-90)  == -1)){

            try {
                throw new Exception("Latitude values are incorrect");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
