package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import com.datastax.oss.driver.api.core.CqlSession;
import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<Object, T> {
    protected final int geoHashLength;
    private final String fieldName;

    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
        this.fieldName = fieldName;
        geoHashLength = AppConfig.cassandra().getConfig("spatialOp").getInt("geoHashLength");
    }

    public void createIndex(String dataCollection, CqlSession session) {
        StringBuilder indexBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        indexBuilder.append(fieldName).append("_geohash_index");
        indexBuilder.append(" ON ").append(dataCollection);
        indexBuilder.append('(').append(fieldName).append("_geohash").append(')');
        indexBuilder.append(';');
        session.execute(indexBuilder.toString());
    }
}
