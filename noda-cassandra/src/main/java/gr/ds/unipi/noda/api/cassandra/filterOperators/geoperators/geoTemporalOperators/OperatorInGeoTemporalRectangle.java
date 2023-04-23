package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;
import org.apache.log4j.helpers.ISO8601DateFormat;
import com.github.davidmoten.geo.GeoHash;
import java.text.DateFormat;

final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder("");
        operation.append(getGeographicalOperator().getOperatorExpression());
        operation.append(" AND ");
        DateFormat df = new ISO8601DateFormat();
        String startDate = df.format(getTemporalType().getLowerBound()).replace(",", "+")+"0";
        String endDate= df.format(getTemporalType().getUpperBound()).replace(",", "+")+"0";
        operation.append(getTemporalFieldName()).append(" >= ").append('\''+startDate+'\'').append(" AND ");
        operation.append(getTemporalFieldName()).append(" <= ").append('\''+endDate+'\'');
        return operation;
    }
}
