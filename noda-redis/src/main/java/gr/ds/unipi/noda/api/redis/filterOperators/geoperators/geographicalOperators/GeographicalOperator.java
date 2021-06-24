package gr.ds.unipi.noda.api.redis.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperators.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperators.Triplet;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

import java.util.ArrayList;
import java.util.List;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<List<Triplet>, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public Ranges getMatchingPattern(){

        final int bits = AppConfig.redis().getInt("spatialOp.bits");
        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(2);

            try {
                long[] lower = HilbertUtil.scaleGeoPoint(getGeometry().getMbr().getLowerBound().getLongitude(), AppConfig.redis().getDouble("spatialOp.minLon"), AppConfig.redis().getDouble("spatialOp.maxLon"), getGeometry().getMbr().getLowerBound().getLatitude(), AppConfig.redis().getDouble("spatialOp.minLat"), AppConfig.redis().getDouble("spatialOp.maxLat"), maxOrdinates);
                long[] upper = HilbertUtil.scaleGeoPoint(getGeometry().getMbr().getUpperBound().getLongitude(), AppConfig.redis().getDouble("spatialOp.minLon"), AppConfig.redis().getDouble("spatialOp.maxLon"), getGeometry().getMbr().getUpperBound().getLatitude(), AppConfig.redis().getDouble("spatialOp.minLat"), AppConfig.redis().getDouble("spatialOp.maxLat"), maxOrdinates);

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
