package gr.unipi.noda.api.redisearch.geographicalOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

/**
 * @author adimo on 11/10/2019
 */
public class OperatorNearestNeighbors extends RediSearchGeographicalOperatorBasedOnSinglePoint {
    private final int neighborsCount;
    private final double maxRadius;

    public int getNeighborsCount() {
        return neighborsCount;
    }

    OperatorNearestNeighbors(String fieldName, Coordinates point, double maxRadius, int neighborsCount) {
        super(fieldName, point);
        this.neighborsCount = neighborsCount;
        this.maxRadius = maxRadius;
    }

    static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, Coordinates point, double maxRadius, int neighborsCount) {
        return new OperatorNearestNeighbors(fieldName, point, maxRadius, neighborsCount);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getLongitude() + StringPool.SPACE + getLatitude() + StringPool.SPACE + maxRadius + StringPool.SPACE + Unit.km.toString() + StringPool.CLOSE_BRACKET;
    }
}
