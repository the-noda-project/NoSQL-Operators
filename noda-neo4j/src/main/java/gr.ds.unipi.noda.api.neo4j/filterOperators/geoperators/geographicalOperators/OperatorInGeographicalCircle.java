package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

public final class OperatorInGeographicalCircle extends GeographicalOperator<Circle> {

    private OperatorInGeographicalCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeographicalCircle(fieldName, circle);
    }


    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();

        int bits = 8;

        long maxOrdinates = 1L << bits;

        SmallHilbertCurve f = HilbertCurve.small().bits(bits).dimensions(2);

        long[] point1 = scalePoint(getGeometry().getMbr().getLowerBound().getLatitude(), getGeometry().getMbr().getLowerBound().getLongitude(), maxOrdinates);
        long[] point2 = scalePoint(getGeometry().getMbr().getUpperBound().getLatitude(), getGeometry().getMbr().getUpperBound().getLongitude(), maxOrdinates);

        int maxRanges = 1;
        Ranges ranges = f.query(point1, point2, maxRanges);
        System.out.println(ranges);
        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();
            System.out.println(range.low());
            System.out.println(range.high());

            if(low != high) {
                sb.append("s.HilbertIndex > " + low + " AND s.HilbertIndex < " + high + " WITH s WHERE distance(point({ srid:7203, x: " + getGeometry().getCircleCenter().getLatitude() + " , y: " + getGeometry().getCircleCenter().getLongitude() + "}), s." + getFieldName() + ") < " + getGeometry().getRadius() );

            } else {
                sb.append("s.HilbertIndex = " + low + " WITH s WHERE distance(point({ srid:7203, x: " + getGeometry().getCircleCenter().getLatitude() + " , y: " + getGeometry().getCircleCenter().getLongitude() + "}), s." + getFieldName() + ") < " + getGeometry().getRadius() );
            }

        });

        return sb;


    }
}