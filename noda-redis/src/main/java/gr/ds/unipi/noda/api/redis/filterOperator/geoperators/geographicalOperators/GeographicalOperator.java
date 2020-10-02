package gr.ds.unipi.noda.api.redis.filterOperator.geoperators.geographicalOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;
import java.util.List;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<List<Triplet>, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    @Override
    public List<Triplet> getOperatorExpression(){
        return null;
    }

    public String getMatchingPattern(){
        return RedisGeographicalOperatorFactory.getGeoHashPart(this.getGeometry())+"-?????????????-??????????";
    }

}
