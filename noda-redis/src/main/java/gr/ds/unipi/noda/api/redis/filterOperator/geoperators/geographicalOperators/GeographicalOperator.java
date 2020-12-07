package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;

import java.util.ArrayList;
import java.util.List;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<List<Triplet>, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    private final String randomString;

    public String getMatchingPattern(){
        System.out.println(RedisGeographicalOperatorFactory.getGeoHashPart(this.getGeometry())+"-*");
        return RedisGeographicalOperatorFactory.getGeoHashPart(this.getGeometry())+"-*";
    }

    protected String getRandomString() {
        return randomString;
    }

    protected abstract String getEvalExpression();

    private String[] getKeysArray(){
        return new String[]{getRandomString(), /*"primaryKeys"*/getFieldName()};
    }

    protected abstract String[] getArgvArray();

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList<>();
        list.add(Triplet.newTriplet(getEvalExpression(), getKeysArray(), getArgvArray()));
        return list;
    }
}
