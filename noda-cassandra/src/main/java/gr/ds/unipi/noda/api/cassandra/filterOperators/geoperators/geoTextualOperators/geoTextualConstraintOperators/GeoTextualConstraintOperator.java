package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import com.datastax.oss.driver.api.core.CqlSession;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<Object, U> {

    private final String fieldName;

    protected GeoTextualConstraintOperator(GeographicalOperator<Object, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {
        super(geographicalOperator, conditionalTextualOperator);
        fieldName = geographicalOperator.getFieldName();
    }

    @Override
    public String[] getOperatorExpression() {
        return null;
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
