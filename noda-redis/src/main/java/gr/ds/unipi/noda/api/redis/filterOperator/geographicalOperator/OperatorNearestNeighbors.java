package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.QuadTreeInstance;

/**
 * @author adimo on 11/10/2019
 */
public class OperatorNearestNeighbors extends GeographicalOperatorBasedOnSinglePoint {
    private final int neighborsCount;

    public int getNeighborsCount() {
        return neighborsCount;
    }

    private OperatorNearestNeighbors(String fieldName, Coordinates point, int neighborsCount) {
        super(fieldName, point);
        this.neighborsCount = neighborsCount;
    }

    static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighborsCount) {
        return new OperatorNearestNeighbors(fieldName, point, neighborsCount);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getLongitude() + StringPool.SPACE + getLatitude() + StringPool.SPACE +
                QuadTreeInstance.getQuadTree().findRadius(getLongitude(), getLatitude(), neighborsCount)
                + StringPool.SPACE + Unit.km.toString() + StringPool.CLOSE_BRACKET;
    }
}