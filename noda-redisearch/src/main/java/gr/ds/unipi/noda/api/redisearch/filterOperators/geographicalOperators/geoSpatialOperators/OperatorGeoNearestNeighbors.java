package gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.QuadTreeInstance;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import io.redisearch.Query;

/**
 * @author adimo on 11/10/2019
 */
public class OperatorGeoNearestNeighbors extends GeoSpatialOperator<Point> {
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
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getGeometry().getPoint().getLongitude() + StringPool.SPACE + getGeometry().getPoint().getLongitude() + StringPool.SPACE +
                QuadTreeInstance.getQuadTree().findRadius(getGeometry().getPoint().getLongitude(), getGeometry().getPoint().getLongitude(), neighborsCount)
                + StringPool.SPACE + Query.GeoFilter.KILOMETERS + StringPool.CLOSE_BRACKET;
    }
}