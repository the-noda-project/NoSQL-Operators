package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators.OperatorInGeographicalCircle;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

import java.util.Date;

final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }


    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();

        int bits = 8;

        long maxOrdinates = 1L << bits;

        SmallHilbertCurve f = HilbertCurve.small().bits(bits).dimensions(3);

        Date lowerDate = new Date(getTemporalType().getLowerBound().getTime());
        Date upperDate = new Date(getTemporalType().getUpperBound().getTime());

        Date lowerHilbertDate = new Date(1180332000000L);
        Date upperHilbertDate = new Date(1180830647000L);

        long[] point1 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), lowerDate.getTime(), lowerHilbertDate.getTime(), upperHilbertDate.getTime(), maxOrdinates);
        long[] point2 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), lowerDate.getTime(),  lowerHilbertDate.getTime(), upperHilbertDate.getTime(), maxOrdinates);

        int maxRanges = 1;
        Ranges ranges = f.query(point1, point2, maxRanges);

        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();
            System.out.println(range.low());
            System.out.println(range.high());

            if(low != high) {
                sb.append("s.STHilbertIndex > " + low + " AND s.STHilbertIndex < " + high + " WITH s WHERE distance(point({ srid :7203, x: " + getGeographicalOperator().getGeometry().getCircleCenter().getLatitude() + " , y: " + getGeographicalOperator().getGeometry().getCircleCenter().getLongitude() + " }), s." + getGeographicalOperator().getFieldName() + ") < " + getGeographicalOperator().getGeometry().getRadius() + " AND " + lowerDate.getTime() + " < s." + getTemporalFieldName()  + " < " + upperDate.getTime() );

            } else {
                sb.append("s.STHilbertIndex = " + low + " WITH s WHERE distance(point({ srid :7203, x: " + getGeographicalOperator().getGeometry().getCircleCenter().getLatitude() + " , y: " + getGeographicalOperator().getGeometry().getCircleCenter().getLongitude() + " }), s." + getGeographicalOperator().getFieldName() + ") < " + getGeographicalOperator().getGeometry().getRadius() + " AND " + lowerDate.getTime() + " < s." + getTemporalFieldName()  + " < " + upperDate.getTime() );

            }


    });

        return sb;


    }
}
