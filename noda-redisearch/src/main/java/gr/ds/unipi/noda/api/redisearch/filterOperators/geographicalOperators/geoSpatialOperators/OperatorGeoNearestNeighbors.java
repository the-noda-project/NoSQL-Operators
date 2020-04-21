package gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.QuadTreeInstance;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import io.redisearch.querybuilder.GeoValue;
import io.redisearch.querybuilder.Value;

/**
 * @author adimo on 11/10/2019
 */
public final class OperatorGeoNearestNeighbors extends GeoSpatialOperator<Point> {
    private final int neighborsCount;

    public int getNeighborsCount() {
        return neighborsCount;
    }

    private OperatorGeoNearestNeighbors(String fieldName, Point point, int neighborsCount) {
        super(fieldName, point);
        this.neighborsCount = neighborsCount;
    }

    static OperatorGeoNearestNeighbors newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighborsCount) {
        return new OperatorGeoNearestNeighbors(fieldName, point, neighborsCount);
    }

    @Override
    protected Value getOperatorField() {
        return new GeoValue(getGeometry().getPoint().getLongitude(), getGeometry().getPoint().getLongitude(),
                QuadTreeInstance.getQuadTree().findRadius(getGeometry().getPoint().getLongitude(), getGeometry().getPoint().getLongitude(), neighborsCount), GeoValue.Unit.KILOMETERS);
    }
}