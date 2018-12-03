package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

import java.util.function.Predicate;

public abstract class GeographicalOperator implements FilterOperator {

    private final String fieldName;
    private final Coordinates[] coordinatesArray;//Contains all the points for a shape. For example, the array contains three points if the shape is triangle.

    protected GeographicalOperator(String fieldName, Coordinates... coordinatesArray) {
        checkCoordinates();
        this.fieldName = fieldName;
        this.coordinatesArray = coordinatesArray;
    }

    protected Coordinates[] getCoordinatesArray() {
        return coordinatesArray;
    }

    protected String getFieldName(){
        return fieldName;
    }

    protected void checkCoordinates()
    {
        for(Coordinates c : coordinatesArray){
        if(longitudeOutOfRange.test(c.getLongitude()) || latitudeOutOfRange.test(c.getLatitude())){
            try {
                throw new Exception("Longitude - Latitude values are incorrect");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }


//
//
//    Coordinates[] getCoordinatesArray();
//    String getFieldName();
//
//    int getGeographicalOperatorId();
//
//    @Override
//    default StringBuilder getJsonStringBuilder(){
//        return formJsonStringOfGeographicalOperator();
//    }
//
//    private StringBuilder formJsonStringOfGeographicalOperator(){
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("{ ");
//
//        switch(getGeographicalOperatorId()){
//            case 0 | 1:
//
//                if(!getFieldName().contains(".")){
//                    sb.append(getFieldName());
//                }
//                else{
//                    sb.append("\"" + getFieldName() + "\"");
//                }
//
//                sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");
//
//                for(Coordinates c : getCoordinatesArray()){
//                    sb.append(" [");
//                    sb.append(c.getLongitude());
//                    sb.append(",");
//                    sb.append(c.getLatitude());
//
//                    sb.append("]");
//                    sb.append(",");
//                }
//
//                sb.deleteCharAt(sb.lastIndexOf(", "));
//
//                sb.append("] ] } } } }");
//                break;
//
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//        }
//                return sb;
//    }
//
//    default void checkLonLatRange(T  longitude, T latitude)
//    {
//        if(longitudeOutOfRange.test(longitude) || latitudeOutOfRange.test(latitude)){
//            try {
//                throw new Exception("Longitude - Latitude values are incorrect");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
////        if((Double.compare(longitude.doubleValue(),180)  == 1) || (Double.compare(longitude.doubleValue(),-180)  == -1)
////        || (Double.compare(latitude.doubleValue(),90)  == 1) || (Double.compare(latitude.doubleValue(),-90)  == -1)){
////
////
////        }
//    }
//
    Predicate<Double> longitudeOutOfRange = (longitude) -> ((Double.compare(longitude.doubleValue(), 180) == 1) || (Double.compare(longitude.doubleValue(), -180) == -1));
    Predicate<Double> latitudeOutOfRange = (latitude) -> ((Double.compare(latitude.doubleValue(), 90) == 1) || (Double.compare(latitude.doubleValue(), -90) == -1));
}
