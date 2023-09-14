package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.config.AppConfig;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName()).append(" IN ");
        int precision = AppConfig.cassandra().getConfig("spatialOp ").getInt("geoHashLength ");
        double topLeftLatitude = getGeometry().getUpperBound().getLatitude();
        double topLeftLongitude = getGeometry().getLowerBound().getLongitude();
        double bottomRightLatitude = getGeometry().getLowerBound().getLatitude();
        double bottomRightLongitude = getGeometry().getUpperBound().getLongitude();
        Set<String> geoHashes = GeoHash.coverBoundingBox(topLeftLatitude, topLeftLongitude, bottomRightLatitude, bottomRightLongitude, precision).getHashes();
        geoHashes = geoHashes.stream().map(str -> "\'"+str+"\'").collect(Collectors.toSet());
        operation.append("(");
        operation.append(String.join(",",geoHashes));
        operation.append(")");
        return operation;
    }
}
