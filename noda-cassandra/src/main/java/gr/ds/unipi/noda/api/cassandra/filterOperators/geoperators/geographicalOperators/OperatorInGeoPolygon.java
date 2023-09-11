package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class OperatorInGeoPolygon extends GeographicalOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }

    @Override
    public String[] getOperatorExpression() {
        String[] operation = new String[3];
        double topLeftLat = getGeometry().getMbr().getUpperBound().getLatitude();
        double topLeftLon = getGeometry().getMbr().getLowerBound().getLongitude();
        double bottomRightLat = getGeometry().getMbr().getLowerBound().getLatitude();
        double bottomRightLon = getGeometry().getMbr().getUpperBound().getLongitude();
        String minGeoHash = '\'' + GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, geoHashLength).getHashes()
                .stream().min(String::compareTo).get() + '\'';
        String maxGeoHash = '\'' + GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, geoHashLength).getHashes()
                .stream().max(String::compareTo).get() + '\'';

        //UDF for the select clause--SELECT clause
        StringBuilder geoUDF = new StringBuilder("INPOLY(");
        geoUDF.append(getFieldName()).append("_longitude").append(",");
        geoUDF.append(getFieldName()).append("_latitude").append(",");
        geoUDF.append('[').append(Arrays.stream(getGeometry().getCoordinatesArray())
                        .map(coordinate -> "(" + coordinate.getLongitude() + "," + coordinate.getLatitude() + ")").collect(Collectors.joining(",")))
                .append(']');
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
