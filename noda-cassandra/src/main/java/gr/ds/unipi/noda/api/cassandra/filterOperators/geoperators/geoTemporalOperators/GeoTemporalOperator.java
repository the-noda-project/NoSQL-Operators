package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;

import com.datastax.oss.driver.api.core.CqlSession;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<Object, T, U> {

    private final String fieldName;
    private static final Map<String, String> monthToInt = new HashMap<String, String>() {
        {
            put("Jan", "01");
            put("Feb", "02");
            put("Mar", "03");
            put("Apr", "04");
            put("May", "05");
            put("Jun", "06");
            put("Jul", "07");
            put("Aug", "08");
            put("Sep", "09");
            put("Oct", "10");
            put("Nov", "11");
            put("Dec", "12");
        }
    };

    protected GeoTemporalOperator(GeographicalOperator<Object, T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
        fieldName = geographicalOperator.getFieldName();
    }

    @Override
    public String[] getOperatorExpression() {
        return null;
    }

    protected String parseDates(Date lowerDate, Date upperDate) {
        String year;
        String month;
        String day;
        StringBuilder dateWhereClause = new StringBuilder();
        year = lowerDate.toString().split(" ")[5];
        month = monthToInt.get(lowerDate.toString().split(" ")[1]);
        day = lowerDate.toString().split(" ")[2];
        dateWhereClause.append(getTemporalFieldName()).append(" >= ");
        dateWhereClause.append("\'").append(year).append('-').append(month).append('-').append(day).append("\'");
        dateWhereClause.append(" AND ");
        dateWhereClause.append(getTemporalFieldName()).append(" <= ");
        year = upperDate.toString().split(" ")[5];
        month = monthToInt.get(upperDate.toString().split(" ")[1]);
        day = upperDate.toString().split(" ")[2];
        dateWhereClause.append("\'").append(year).append('-').append(month).append('-').append(day).append("\'");
        return dateWhereClause.toString();
    }

    public void createIndex(String dataCollection, CqlSession session) {
        StringBuilder indexBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        indexBuilder.append(fieldName).append("_geohash_index");
        indexBuilder.append(" ON ").append(dataCollection);
        indexBuilder.append('(').append(fieldName).append("_geohash").append(')');
        indexBuilder.append(';');
        session.execute(indexBuilder.toString());
    }
}
