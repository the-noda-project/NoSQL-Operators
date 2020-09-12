package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators.OperatorInGeographicalCircle;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

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


        long[] point1 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), getTemporalType().getLowerBound().getTime(), 1567296299, 1569887618, maxOrdinates);
        long[] point2 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), getTemporalType().getLowerBound().getTime(),  1567296299, 1569887618, maxOrdinates);
//// return just one range
        System.out.println("POINT 1 = " + point1);
        System.out.println("POINT 2 = " + point2);
        int maxRanges = 1;
        Ranges ranges = f.query(point1, point2, maxRanges);
        System.out.println(ranges);
        System.out.println("MIN: " + getTemporalType().getLowerBound().getTime());
        System.out.println("MAX: " + getTemporalType().getUpperBound().getTime());
        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();
            System.out.println(range.low());
            System.out.println(range.high());

            sb.append("s.STHilbertIndex > " + low + " AND s.STHilbertIndex < " + high + " WITH s WHERE distance(point({ srid :4326, x: " + getGeographicalOperator().getGeometry().getCircleCenter().getLongitude() + " , y: " + getGeographicalOperator().getGeometry().getCircleCenter().getLatitude() + " }), s." + getGeographicalOperator().getFieldName() + ") < " + getGeographicalOperator().getGeometry().getRadius() + " AND " + getTemporalType().getLowerBound().getTime() + " < s." + getTemporalFieldName()  + " < " + getTemporalType().getUpperBound().getTime() );

        });

        return sb;


    }
}
