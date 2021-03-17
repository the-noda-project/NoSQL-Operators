package gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperators.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperators.Triplet;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;
import java.util.ArrayList;
import java.util.List;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<List<Triplet>, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<List<Triplet>,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public Ranges getMatchingPattern(){

        final int bits = AppConfig.redis().getInt("spatioTempOp.bits");
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(3);

        if(getTemporalType() instanceof TemporalBounds){
            try {
                long[] lower = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), AppConfig.redis().getDouble("spatioTempOp.minLon"), AppConfig.redis().getDouble("spatioTempOp.maxLon"), getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), AppConfig.redis().getDouble("spatioTempOp.minLat"), AppConfig.redis().getDouble("spatioTempOp.maxLat"), ((TemporalBounds) getTemporalType()).getLowerBound().getTime(), AppConfig.redis().getLong("spatioTempOp.minDate"), AppConfig.redis().getLong("spatioTempOp.maxDate"), maxOrdinates);
                long[] upper = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), AppConfig.redis().getDouble("spatioTempOp.minLon"), AppConfig.redis().getDouble("spatioTempOp.maxLon"), getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), AppConfig.redis().getDouble("spatioTempOp.minLat"), AppConfig.redis().getDouble("spatioTempOp.maxLat"), ((TemporalBounds) getTemporalType()).getUpperBound().getTime(), AppConfig.redis().getLong("spatioTempOp.minDate"), AppConfig.redis().getLong("spatioTempOp.maxDate"), maxOrdinates);

                Ranges ranges = hc.query(lower,upper ,0);
                return ranges;
//                System.out.println("List "+rangesList.get(0).low()+" "+ rangesList.get(0).high());
//                return rangesList.get(0).low()+"-"+rangesList.get(0).high();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            try {
                throw new Exception("Single Temporal Value cannot be handled");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
//        if(getTemporalType() instanceof TemporalBounds){
//            System.out.println(RedisGeographicalOperatorFactory.getGeoHashPart(getGeographicalOperator().getGeometry()) +"-"+RedisGeoTemporalOperatorFactory.getTemporalPart(((TemporalBounds) getTemporalType()).getLowerBound(), ((TemporalBounds) getTemporalType()).getUpperBound())+"-*");
//            return RedisGeographicalOperatorFactory.getGeoHashPart(getGeographicalOperator().getGeometry()) +"-"+RedisGeoTemporalOperatorFactory.getTemporalPart(((TemporalBounds) getTemporalType()).getLowerBound(), ((TemporalBounds) getTemporalType()).getUpperBound())+"-*";
//        }
//        else{
//            try {
//                throw new Exception("Single Temporal Value cannot be handled");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
    }

    protected String getRandomString() {
        return randomString;
    }

    protected abstract String getEvalExpression();

    private String[] getKeysArray(){
        return new String[]{getRandomString(), /*"primaryKeys"*/getGeographicalOperator().getFieldName()+":"+getTemporalFieldName()};
    }

    protected abstract String[] getArgvArray(String range);

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList<>();

        getMatchingPattern().forEach(range -> {
            list.add(Triplet.newTriplet(getEvalExpression(), getKeysArray(), getArgvArray(range.low()+"-"+range.high())));
        });
        return list;
    }
}
