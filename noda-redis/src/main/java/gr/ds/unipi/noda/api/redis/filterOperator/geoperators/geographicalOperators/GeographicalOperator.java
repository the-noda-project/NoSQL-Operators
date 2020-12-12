package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<List<Triplet>, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public Ranges getMatchingPattern(){

        final int bits = 6;
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

            try {
                long[] lower = HilbertUtil.scaleGeoPoint(getGeometry().getMbr().getLowerBound().getLatitude(),getGeometry().getMbr().getLowerBound().getLongitude(), maxOrdinates);
                long[] upper = HilbertUtil.scaleGeoPoint(getGeometry().getMbr().getUpperBound().getLatitude(),getGeometry().getMbr().getUpperBound().getLongitude(), maxOrdinates);

                Ranges ranges = hc.query(lower, upper ,0);
                return ranges;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return null;
    }

    protected String getRandomString() {
        return randomString;
    }

    protected abstract String getEvalExpression();

    private String[] getKeysArray(){
        return new String[]{getRandomString(), /*"primaryKeys"*/getFieldName()};
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
