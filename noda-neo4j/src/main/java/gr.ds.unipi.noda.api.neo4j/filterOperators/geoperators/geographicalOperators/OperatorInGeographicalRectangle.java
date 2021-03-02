package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

public final class OperatorInGeographicalRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeographicalRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeographicalRectangle newOperatorInGeographicalRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeographicalRectangle(fieldName, rectangle);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        int bits = 8;
        long maxOrdinates = 1L << bits;
        SmallHilbertCurve f = HilbertCurve.small().bits(bits).dimensions(2);
        System.out.println(getGeometry().getLowerBound().getLatitude() +" " + getGeometry().getLowerBound().getLongitude());
        long[] point1 = scalePoint(getGeometry().getLowerBound().getLatitude(), getGeometry().getLowerBound().getLongitude(), maxOrdinates);
        long[] point2 = scalePoint(getGeometry().getUpperBound().getLatitude(), getGeometry().getUpperBound().getLongitude(), maxOrdinates);
//// return just one range
        int maxRanges = 1;
        Ranges ranges = f.query(point1, point2, maxRanges);
        System.out.println(ranges);
        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();
            System.out.println(range.low());
            System.out.println(range.high());

            if(low != high) {
                sb.append("s.HilbertIndex > " + low + " AND s.HilbertIndex < " + high + " WITH s WHERE point({ srid:7203 , x: " + getGeometry().getLowerBound().getLatitude() + ", y: "+ getGeometry().getLowerBound().getLongitude() +" }) < s." + getFieldName() + " < point({ srid: 7203 , x: " + getGeometry().getUpperBound().getLatitude() + ", y: "+ getGeometry().getUpperBound().getLongitude() + " })" );

            } else {
                sb.append("s.HilbertIndex = " + low + " WITH s WHERE point({ srid:7203 , x: " + getGeometry().getLowerBound().getLatitude() + ", y: "+ getGeometry().getLowerBound().getLongitude() +" }) < s." + getFieldName() + " < point({ srid: 7203 , x: " + getGeometry().getUpperBound().getLatitude() + ", y: "+ getGeometry().getUpperBound().getLongitude() + " })" );
            }
//            point({ x: 1, y: 5 })< person.location < point({ x: 2, y: 6 })

//            sb.append(" point({ srid:7203 , x: " + getGeometry().getLowerBound().getLatitude() + ", y: "+ getGeometry().getLowerBound().getLongitude() +" }) < s." + getFieldName() + " < point({ srid: 7203 , x: " + getGeometry().getUpperBound().getLatitude() + ", y: "+ getGeometry().getUpperBound().getLongitude() + " })" );


        });


//        System.out.println(getGeometry().getLowerBound());
        return sb;
    }

}
