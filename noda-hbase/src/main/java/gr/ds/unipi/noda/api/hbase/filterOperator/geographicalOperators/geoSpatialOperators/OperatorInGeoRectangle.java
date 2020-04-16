package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;
import org.apache.hadoop.hbase.filter.Filter;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

final class OperatorInGeoRectangle extends GeoSpatialOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    protected Filter geometryRefactor() {
        return (Filter) and(gte(getFieldName() + ":lon", getGeometry().getLowerBound().getLongitude()),
                gte(getFieldName() + ":lat", getGeometry().getLowerBound().getLatitude()),
                lte(getFieldName() + ":lon", getGeometry().getUpperBound().getLongitude()),
                lte(getFieldName() + ":lat", getGeometry().getUpperBound().getLatitude())).getOperatorExpression();
    }

}
