package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;
import gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators.RedisGeographicalOperatorFactory;

import java.util.ArrayList;
import java.util.List;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<List<Triplet>, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<List<Triplet>,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public String getMatchingPattern(){

        if(getTemporalType() instanceof TemporalBounds){
            return RedisGeographicalOperatorFactory.getGeoHashPart(getGeographicalOperator().getGeometry()) +"-"+RedisGeoTemporalOperatorFactory.getTemporalPart(((TemporalBounds) getTemporalType()).getLowerBound(), ((TemporalBounds) getTemporalType()).getUpperBound())+"-*";
        }
        else{
            try {
                throw new Exception("Single Temporal Value cannot be handled");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    protected String getRandomString() {
        return randomString;
    }

    protected abstract String getEvalExpression();

    private String[] getKeysArray(){
        return new String[]{getRandomString(), "primaryKeys"};
    }

    protected abstract String[] getArgvArray();

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList<>();
        list.add(Triplet.newTriplet(getEvalExpression(), getKeysArray(), getArgvArray()));
        return list;
    }
}
