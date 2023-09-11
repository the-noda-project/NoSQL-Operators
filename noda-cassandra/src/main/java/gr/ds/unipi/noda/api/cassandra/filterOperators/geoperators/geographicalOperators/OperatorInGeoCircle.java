package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }


    @Override
    public String[] getOperatorExpression() {
        String[] operation = new String[2];
        double topLeftLat = getGeometry().getMbr().getUpperBound().getLatitude();
        double topLeftLon = getGeometry().getMbr().getLowerBound().getLongitude();
        double bottomRightLat = getGeometry().getMbr().getLowerBound().getLatitude();
        double bottomRightLon = getGeometry().getMbr().getUpperBound().getLongitude();
        String minGeoHash = '\'' + GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, geoHashLength).getHashes()
                .stream().min(String::compareTo).get() + '\'';
        String maxGeoHash = '\'' + GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, geoHashLength).getHashes()
                .stream().max(String::compareTo).get() + '\'';
        //UDF for the select clause--SELECT clause
        StringBuilder geoUDF = new StringBuilder("INCIRCLE(");
        geoUDF.append(getFieldName()).append("_longitude").append(",");
        geoUDF.append(getFieldName()).append("_latitude").append(",");
        geoUDF.append(getGeometry().getCircleCenter().getLongitude()).append(',');
        geoUDF.append(getGeometry().getCircleCenter().getLatitude()).append(',');
        geoUDF.append(getGeometry().getRadius());
        geoUDF.append(")");
        operation[0] = geoUDF.toString();

        //Get the geoHashes--WHERE clause
        StringBuilder geoHashBound = new StringBuilder();
        geoHashBound.append(getFieldName()).append("_geohash >=").append(minGeoHash);
        geoHashBound.append(" AND ");
        geoHashBound.append(getFieldName()).append("_geohash <=").append(maxGeoHash);
        operation[1] = geoHashBound.toString();

        return operation;
    }

}