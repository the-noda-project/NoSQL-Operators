package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        int geohashLength = 3;
        final double upperLon = getGeometry().getMbr().getUpperBound().getLongitude();
        final double lowerLon = getGeometry().getMbr().getLowerBound().getLongitude();
        final double upperLat = getGeometry().getMbr().getUpperBound().getLatitude();
        final double lowerLat = getGeometry().getMbr().getLowerBound().getLatitude();

        Set<String> hashes = GeoHash.coverBoundingBox(upperLat, upperLon, lowerLat, lowerLon, geohashLength)
                .getHashes();

        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                String fieldName = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) + "_geohash\"]";
                String hashMin = "\"" + hashes.stream().min(String::compareTo).orElse("") + "\"";
                String hashMax = "\"" + hashes.stream().max(String::compareTo).orElse("") + "\"";

                return fieldName + ".slice(0, " + geohashLength + ") >= " + hashMin + " && " + fieldName +
                        ".slice(0, " + geohashLength + ") <= " + hashMax;
            }

            @Override
            public Map<String, Object> asFindFilter() {
                ArrayList<Map<String, String>> selectors = new ArrayList<>();

                for (String hash : hashes) {
                    selectors.add(Collections.singletonMap("$regex", "^" + hash));
                }

                return Collections.singletonMap(getFieldName() + "_geohash",
                        Collections.singletonMap("$or", selectors)
                );
            }
        };
    }
}