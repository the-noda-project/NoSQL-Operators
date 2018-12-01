package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnShape extends GeographicalOperator {

    protected GeographicalOperatorBasedOnShape(String fieldName, Coordinates... coordinates){
        super(fieldName, coordinates);
    }

    @Override
    public StringBuilder getJsonStringBuilder(){

       StringBuilder sb = new StringBuilder();
        sb.append("{ ");

                if(!getFieldName().contains(".")){
                    sb.append(getFieldName());
                }
                else{
                    sb.append("\"" + getFieldName() + "\"");
                }

                sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");

                for(Coordinates c : getCoordinatesArray()){
                    sb.append(" [");
                    sb.append(c.getLongitude());
                    sb.append(",");
                    sb.append(c.getLatitude());

                    sb.append("]");
                    sb.append(",");
                }

                sb.deleteCharAt(sb.lastIndexOf(", "));

                sb.append("] ] } } } }");

                return sb;

    }

}
