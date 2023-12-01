package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class GeoTemporalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<FilterStrategy, T, TemporalBounds> {
    protected GeoTemporalOperator(GeographicalOperator<FilterStrategy, T> geographicalOperator, String temporalFieldName, TemporalBounds temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        final FilterStrategy geographicalOperator = getGeographicalOperator().getOperatorExpression();

        OffsetDateTime lowerDateBound = OffsetDateTime.from(getTemporalType().getLowerBound()
                .toInstant()
                .atOffset(ZoneOffset.UTC));

        OffsetDateTime upperDateBound = OffsetDateTime.from(getTemporalType().getUpperBound()
                .toInstant()
                .atOffset(ZoneOffset.UTC));

        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                final String temporal = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getTemporalFieldName()) + "\"]";

                return temporal + " >= \"" + lowerDateBound + "\" && " + temporal + " <= \"" + upperDateBound +
                        "\" &&" + geographicalOperator.asMapFilter();
            }

            @Override
            public Map<String, Object> asFindFilter() {
                HashMap<String, String> timeFilter = new HashMap<>();
                timeFilter.put("$gte", lowerDateBound.toString());
                timeFilter.put("$lte", upperDateBound.toString());
                return Collections.singletonMap("$and",
                        Arrays.asList(Collections.singletonMap(getTemporalFieldName(), timeFilter),
                                geographicalOperator.asFindFilter()
                        )
                );
            }
        };
    }
}
