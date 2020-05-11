package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators;

import gr.ds.unipi.noda.api.core.constants.Commons;
import gr.ds.unipi.qtree.Point;
import gr.ds.unipi.qtree.QuadTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

public final class QuadTreeInstance {
    private static final Logger logger = LoggerFactory.getLogger(QuadTreeInstance.class);
    private static QuadTree quadTree;

    private QuadTreeInstance() {
        try {
            quadTree = QuadTree.deserializeQuadTree(Commons.BASE_PATH);
        } catch (FileNotFoundException e) {
            logger.error("Caution, returning empty QuadTree instance due to", e);
            quadTree = null;
        }
    }

    private static class InstanceHolder {
        private static final QuadTreeInstance INSTANCE = new QuadTreeInstance();
    }

    public static QuadTreeInstance getQuadTree() {
        return InstanceHolder.INSTANCE;
    }

    public double findRadius(double longitude, double latitude, long neighboors) {
        return quadTree.determineRadiusOfPoint((int) neighboors, Point.newPoint(longitude, latitude));
    }
}