package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<StringBuilder, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();

        sb.append("{ $and: [");

        sb.append(MongoDBGeographicalOperatorFactory.getGeometryExpression(getFieldName(), getGeometry()));
        sb.append(", ");

        sb.append(MongoDBGeographicalOperatorFactory.getExpressionOfSpatialHilbertIndexes(getGeometry().getMbr()));
        sb.append(" ] }");

        return sb;
    }

}
