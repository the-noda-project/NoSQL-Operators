package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        final double lowerLat = getGeometry().getLowerBound().getLatitude();
        final double upperLat = getGeometry().getUpperBound().getLatitude();
        final double lowerLon = getGeometry().getLowerBound().getLongitude();
        final double upperLon = getGeometry().getUpperBound().getLongitude();

        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                final String longitude = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) + "\"][0]";
                final String latitude = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) + "\"][1]";

                return longitude + " >= " + lowerLon + " && " + longitude + " <= " + upperLon + " && " + latitude +
                        " >= " + lowerLat + " && " + latitude + " <= " + upperLat;
            }

            @Override
            public Map<String, Object> asFindFilter() {
                HashMap<String, Double[]> filter = new HashMap<>();
                filter.put("$gte", new Double[]{lowerLon, lowerLat});
                filter.put("$lte", new Double[]{upperLon, upperLat});

                return Collections.singletonMap(getFieldName(), filter);
            }
        };
    }
}
