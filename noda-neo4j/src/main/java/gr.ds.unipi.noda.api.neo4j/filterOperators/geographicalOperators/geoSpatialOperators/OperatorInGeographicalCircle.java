package gr.ds.unipi.noda.api.neo4j.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

final class OperatorInGeographicalCircle extends GeoSpatialOperator<Circle> {

    private OperatorInGeographicalCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Circle circle) {
        return new OperatorInGeographicalCircle(fieldName, circle);
    }


    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();

        sb.append("distance(point({latitude: "+getGeometry().getCircleCenter().getLatitude()+" , longitude: "+getGeometry().getCircleCenter().getLongitude()+"}), s."+getFieldName()+") < "+ getGeometry().getRadius());

        return sb;
    }
}