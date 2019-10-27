package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.sttk.kNNOverRangeQueries.gridPartitioning.LoadHistogram;
import gr.ds.unipi.sttk.kNNOverRangeQueries.gridPartitioning.RadiusDetermination;

/**
 * @author adimo on 11/10/2019
 */
public class OperatorNearestNeighbors extends GeographicalOperatorBasedOnSinglePoint {
    private final int neighborsCount;
    private final double radius;

    public int getNeighborsCount() {
        return neighborsCount;
    }

    private OperatorNearestNeighbors(String fieldName, Coordinates point, double radius, int neighborsCount) {
        super(fieldName, point);
        this.neighborsCount = neighborsCount;
        this.radius = radius;
    }

    public static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighborsCount) {
        LoadHistogram histogram = LoadHistogram.newLoadHistogram(OperatorNearestNeighbors.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        RadiusDetermination radiusDetermination = RadiusDetermination.newRadiusDetermination(histogram.getHistogram(),
                histogram.getNumberOfCellsxAxis(), histogram.getNumberOfCellsyAxis(), histogram.getMinx(),
                histogram.getMiny(), histogram.getMaxx(), histogram.getMaxy());
        double radius = radiusDetermination.findRadius(point.getLongitude(), point.getLatitude(), neighborsCount);
        return new OperatorNearestNeighbors(fieldName, point, radius, neighborsCount);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getLongitude() + StringPool.SPACE + getLatitude() + StringPool.SPACE + radius + StringPool.SPACE + Unit.km.toString() + StringPool.CLOSE_BRACKET;
    }
}
