package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;
import gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators.RedisGeographicalOperatorFactory;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Range;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<List<Triplet>, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<List<Triplet>,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public Ranges getMatchingPattern(){

        final int bits = 6;
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

        if(getTemporalType() instanceof TemporalBounds){
            try {
                long[] lower = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLongitude(), 19.632533, 28.245286, getGeographicalOperator().getGeometry().getMbr().getLowerBound().getLatitude(), 34.929233, 41.757798, ((TemporalBounds) getTemporalType()).getLowerBound().getTime(), sdf.parse("2018-07-01T00:00:00.000").getTime(), sdf.parse("2018-11-30T23:59:59.999").getTime(), maxOrdinates);
                long[] upper = HilbertUtil.scaleGeoTemporalPoint(getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLongitude(), 19.632533, 28.245286, getGeographicalOperator().getGeometry().getMbr().getUpperBound().getLatitude(), 34.929233, 41.757798, ((TemporalBounds) getTemporalType()).getUpperBound().getTime(), sdf.parse("2018-07-01T00:00:00.000").getTime(), sdf.parse("2018-11-30T23:59:59.999").getTime(), maxOrdinates);

                long t1 = System.currentTimeMillis();
                Ranges ranges = hc.query(lower,upper ,0);
                System.out.println(System.currentTimeMillis()-t1+" ms");

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
        return new String[]{getRandomString(), /*"primaryKeys"*/getGeographicalOperator().getFieldName()};
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
