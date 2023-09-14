package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

import java.util.Set;
import java.util.stream.Collectors;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public StringBuilder getOperatorExpression (){
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName()).append(" IN ");
        int precision = AppConfig.cassandra().getConfig("spatialOp ").getInt("geoHashLength ");
        double topLeftLatitude = getGeometry().getMbr().getUpperBound().getLatitude();
        double topLeftLongitude = getGeometry().getMbr().getLowerBound().getLongitude();
        double bottomRightLatitude = getGeometry().getMbr().getLowerBound().getLatitude();
        double bottomRightLongitude = getGeometry().getMbr().getUpperBound().getLongitude();
        Set<String> geoHashes = GeoHash.coverBoundingBox(topLeftLatitude, topLeftLongitude, bottomRightLatitude, bottomRightLongitude, precision).getHashes();
        geoHashes = geoHashes.stream().map(str -> "\'"+str+"\'").collect(Collectors.toSet());
        operation.append("(");
        operation.append(String.join(",",geoHashes));
        operation.append(")");
        return operation;
    }

}