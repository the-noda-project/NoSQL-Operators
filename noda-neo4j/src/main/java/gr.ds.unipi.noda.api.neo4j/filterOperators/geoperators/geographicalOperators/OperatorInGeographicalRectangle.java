package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
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
//        int bits = 8;
//        long maxOrdinates = 1L << bits;
        final int bits = AppConfig.neo4j().getInt("spatialOp.bits");
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve f = HilbertCurve.small().bits(bits).dimensions(2);
        System.out.println(getGeometry().getLowerBound().getLatitude() +" " + getGeometry().getLowerBound().getLongitude());
//        long[] point1 = scalePoint(getGeometry().getLowerBound().getLatitude(), getGeometry().getLowerBound().getLongitude(), maxOrdinates);
//        long[] point2 = scalePoint(getGeometry().getUpperBound().getLatitude(), getGeometry().getUpperBound().getLongitude(), maxOrdinates);

        long[] lower = HilbertUtil.scaleGeoPoint(getGeometry().getLowerBound().getLongitude(), AppConfig.neo4j().getDouble("spatialOp.minLon"), AppConfig.neo4j().getDouble("spatialOp.maxLon"), getGeometry().getLowerBound().getLatitude(), AppConfig.neo4j().getDouble("spatialOp.minLat"), AppConfig.neo4j().getDouble("spatialOp.maxLat"), maxOrdinates);
        long[] upper = HilbertUtil.scaleGeoPoint(getGeometry().getUpperBound().getLongitude(), AppConfig.neo4j().getDouble("spatialOp.minLon"), AppConfig.neo4j().getDouble("spatialOp.maxLon"), getGeometry().getUpperBound().getLatitude(), AppConfig.neo4j().getDouble("spatialOp.minLat"), AppConfig.neo4j().getDouble("spatialOp.maxLat"), maxOrdinates);


        int maxRanges = 1;
        //Ranges ranges = f.query(point1, point2, maxRanges);
        Ranges ranges = f.query(lower, upper, maxRanges);
        System.out.println(ranges);
        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();
            System.out.println(range.low());
            System.out.println(range.high());

            if(low != high) {
                sb.append("s.hilIndex > " + low + " AND s.hilIndex < " + high + " WITH s WHERE point({ srid:4326 , x: " + getGeometry().getLowerBound().getLongitude() + ", y: "+ getGeometry().getLowerBound().getLatitude() +" }) < s." + getFieldName() + " < point({ srid: 4326 , x: " + getGeometry().getUpperBound().getLongitude() + ", y: "+ getGeometry().getUpperBound().getLatitude() + " })" );

            } else {
                sb.append("s.hilIndex = " + low + " WITH s WHERE point({ srid:4326 , x: " + getGeometry().getLowerBound().getLongitude() + ", y: "+ getGeometry().getLowerBound().getLatitude() +" }) < s." + getFieldName() + " < point({ srid: 4326 , x: " + getGeometry().getUpperBound().getLongitude() + ", y: "+ getGeometry().getUpperBound().getLatitude() + " })" );
            }

        });


        return sb;
    }

}
