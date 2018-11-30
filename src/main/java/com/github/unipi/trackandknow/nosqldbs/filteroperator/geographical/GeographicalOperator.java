package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

import java.util.function.Predicate;

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

    final Predicate<Double> longitudeOutOfRange = (double longitude) -> ((Float.compare(longitude, 180) == 1) || (Float.compare(longitude, -180) == -1));
    final Predicate<Double> latitudeOutOfRange = (double latitude) -> ((Float.compare(latitude, 90) == 1) || (Float.compare(latitude, -90) == -1));
}
