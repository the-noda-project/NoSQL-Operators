package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators.OperatorInGeographicalRectangle;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

import java.util.Date;

final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeographicalRectangle.newOperatorInGeographicalRectangle(fieldName, rectangle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();

//        int bits = 8;
//
//        long maxOrdinates = 1L << bits;
        final int bits = AppConfig.neo4j().getInt("spatioTempOp.bits");
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve f = HilbertCurve.small().bits(bits).dimensions(3);

        Date lowerDate = new Date(getTemporalType().getLowerBound().getTime());
        Date upperDate = new Date(getTemporalType().getUpperBound().getTime());

//        Date lowerHilbertDate = new Date(1180332000000L);
//        Date upperHilbertDate = new Date(1180830647000L);

//        long[] point1 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), lowerDate.getTime(), lowerHilbertDate.getTime(), upperHilbertDate.getTime(), maxOrdinates);
//        long[] point2 = scalePoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), lowerDate.getTime(), lowerHilbertDate.getTime(), upperHilbertDate.getTime(), maxOrdinates);
        long[] lower = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), AppConfig.neo4j().getDouble("spatioTempOp.minLon"), AppConfig.neo4j().getDouble("spatioTempOp.maxLon"), getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), AppConfig.neo4j().getDouble("spatioTempOp.minLat"), AppConfig.neo4j().getDouble("spatioTempOp.maxLat"), ((TemporalBounds) getTemporalType()).getLowerBound().getTime(), AppConfig.neo4j().getLong("spatioTempOp.minDate"), AppConfig.neo4j().getLong("spatioTempOp.maxDate"), maxOrdinates);
        long[] upper = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), AppConfig.neo4j().getDouble("spatioTempOp.minLon"), AppConfig.neo4j().getDouble("spatioTempOp.maxLon"), getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), AppConfig.neo4j().getDouble("spatioTempOp.minLat"), AppConfig.neo4j().getDouble("spatioTempOp.maxLat"), ((TemporalBounds) getTemporalType()).getUpperBound().getTime(), AppConfig.neo4j().getLong("spatioTempOp.minDate"), AppConfig.neo4j().getLong("spatioTempOp.maxDate"), maxOrdinates);


        int maxRanges = 1;
        //Ranges ranges = f.query(point1, point2, maxRanges);
        Ranges ranges = f.query(lower, upper, maxRanges);

        ranges.forEach(range -> {
            long low = range.low();
            long high = range.high();


            if(low != high) {
                sb.append("s.STHilbertIndex > " + low + " AND s.STHilbertIndex < " + high + " WITH s WHERE point({ srid:7203 , x: " + getGeographicalOperator().getGeometry().getLowerBound().getLatitude() + ", y: "+ getGeographicalOperator().getGeometry().getLowerBound().getLongitude() +" }) < s." + getGeographicalOperator().getFieldName() + " < point({ srid: 7203 , x: " + getGeographicalOperator().getGeometry().getUpperBound().getLatitude() + ", y: "+ getGeographicalOperator().getGeometry().getUpperBound().getLongitude() + " }) AND " + lowerDate.getTime() + " < s." + getTemporalFieldName()  + " < " + upperDate.getTime() );

            } else {
                sb.append("s.STHilbertIndex = " + low + " WITH s WHERE point({ srid:7203 , x: " + getGeographicalOperator().getGeometry().getLowerBound().getLatitude() + ", y: "+ getGeographicalOperator().getGeometry().getLowerBound().getLongitude() +" }) < s." + getGeographicalOperator().getFieldName() + " < point({ srid: 7203 , x: " + getGeographicalOperator().getGeometry().getUpperBound().getLatitude() + ", y: "+ getGeographicalOperator().getGeometry().getUpperBound().getLongitude() + " }) AND " + lowerDate.getTime() + " < s." + getTemporalFieldName()  + " < " + upperDate.getTime() );

            }

        });

        return sb;

    }

}
